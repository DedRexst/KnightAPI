package com.example.knightapi.models;

import com.example.knightapi.models.Knight;
import com.example.knightapi.services.Inventory;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "chestplate")
public class Chestplate extends Inventory {
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "chestplateID")
    private Set<Knight> knights;


}
