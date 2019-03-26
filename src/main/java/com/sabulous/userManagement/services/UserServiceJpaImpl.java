package com.sabulous.userManagement.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import com.sabulous.userManagement.model.User;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("jpaTest")
class UserServiceJpaImpl implements UserService {

    private EntityManagerFactory emf;

    @PersistenceUnit
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    } 

    @Override
    public void printUsers() {
    }

    @Override
    public List<User> getAllUsers() {
        EntityManager em = emf.createEntityManager();
        List<User> list = em.createQuery("FROM User", User.class).getResultList();
        em.close();
        
        if(list == null) list = new ArrayList<User>();

        return list;
    }

    @Override
    public User getUserById(int id) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        User user = em.find(User.class, id);
        em.getTransaction().commit();
        em.close();

        return user;
    }

    @Override
    public User addOrEditUser(User user) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        User savedUser = em.merge(user);
        em.getTransaction().commit();
        em.close();

        return savedUser;
    }

    @Override
    public void deleteUser(int id) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.remove(em.find(User.class, id));
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Integer findNextId() {
        EntityManager em = emf.createEntityManager();
        Integer maxId = (Integer) em.createQuery("SELECT MAX(id) FROM User").getResultList().get(0);
        em.close();

        if(maxId == null) maxId = 0;

        return maxId + 1;
    }
}

// TODO: fix findNextId bug that occurs when all entries are deleted and then new entry is persisted.
