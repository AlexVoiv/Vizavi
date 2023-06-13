package com.vizavi.application.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "products")
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type_of_product")
    private String type;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;
    @ManyToMany(mappedBy = "products")
    private Set<User> users;
}
