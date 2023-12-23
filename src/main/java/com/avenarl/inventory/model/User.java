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
}
