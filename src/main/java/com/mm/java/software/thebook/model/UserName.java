package com.mm.java.software.thebook.model;

import jakarta.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class UserName {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String name;
    private String email;

    public UserName() {
    }

    public UserName(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public UserName(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
