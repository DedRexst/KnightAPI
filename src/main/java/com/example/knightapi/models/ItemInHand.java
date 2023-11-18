package com.example.knightapi.models;

import com.example.knightapi.models.Knight;
import com.example.knightapi.services.Inventory;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "iteminhand")
public class ItemInHand extends Inventory {
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "itemInRightHandID")
    private Set<Knight> knightsWhoHoldItemInRightHand;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "itemInLeftHandID")
    private Set<Knight> knightsWhoHoldItemInLeftHand;
}
