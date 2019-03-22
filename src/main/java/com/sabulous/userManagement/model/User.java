package com.sabulous.userManagement.model;

public class User {
    private int id;
    private String name;
    private String roleGroup;

    public User(int id, String name, String roleGroup) {
        this.id = id;
        this.name = name;
        this.roleGroup = roleGroup;
    }

    public void introduce() {
        System.out.println("Id : " + this.id);
        System.out.println("Name : " + this.name);
        System.out.println("Role Group : " + this.roleGroup);
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the roleGroup
     */
    public String getRoleGroup() {
        return roleGroup;
    }

    /**
     * @param roleGroup the roleGroup to set
     */
    public void setRoleGroup(String roleGroup) {
        this.roleGroup = roleGroup;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
}