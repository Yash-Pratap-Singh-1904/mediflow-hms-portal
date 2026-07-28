package com.hms.model;

import java.io.Serializable;

public abstract class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String id;
    private String name;
    private String contact;
    private int age;
    private String password;
    private final UserRole role;

    public User(String id, String name, String contact, int age, String password, UserRole role) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.age = age;
        this.password = password;
        this.role = role;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getContact() { return contact; }
    public int getAge() { return age; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public UserRole getRole() { return role; }

    public boolean validatePassword(String inputPassword) {
        return this.password != null && this.password.equals(inputPassword);
    }
}