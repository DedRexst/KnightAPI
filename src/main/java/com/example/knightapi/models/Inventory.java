package com.example.knightapi.services;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@MappedSuperclass
@Data
@ToString
public abstract class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    protected int id;
    @Column(name = "name", nullable = false)
    protected String name;
    @Column(name = "type", nullable = false)
    protected String type;
    @Column(name = "weight", nullable = false)
    protected float weight;
    @Column(name = "value", nullable = false)
    protected float value;


}
