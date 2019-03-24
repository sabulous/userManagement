package com.sabulous.userManagement.model;

public class User {
    private Integer id;
    private String name;
    private String roleGroup;

    public User() {}

    public User(int id) {
        this.id  = id;
    }

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

    public Integer getId() {
        return id;
    }

    public String getRoleGroup() {
        return roleGroup;
    }

    public void setRoleGroup(String roleGroup) {
        this.roleGroup = roleGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
