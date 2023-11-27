package com.avenarl.inventory.model;

import jakarta.persistence.*;

@Entity
@Table(name="product", schema="public")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;
}
