package com.example.knightapi.models;

import com.example.knightapi.models.Knight;
import com.example.knightapi.services.Inventory;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Set;

@Entity
@Table(name = "armorkneepads")
public class ArmorKneePads extends Inventory {
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "armorKneePadsID")
    private Set<Knight> knights;
}