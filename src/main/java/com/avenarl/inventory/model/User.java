package com.avenarl.inventory.model;

import jakarta.persistence.*;

@Entity
@Table(name="user", schema="public")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long uid;

    @Column
    private String username;

    @Column
    private String password;

    public User(Long uid, String username, String password) {
        this.uid = uid;
        this.username = username;
        this.password = password;
    }
}
