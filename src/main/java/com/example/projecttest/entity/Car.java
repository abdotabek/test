package com.example.projecttest.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "model")
    private String model;
    @Column(name = "price")
    private double price;
}
