package com.example.knightapi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "knight")
public class Knight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "iteminrighthandID", nullable = false)
    private ItemInHand itemInRightHandID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iteminlefthandID")
    private ItemInHand itemInLeftHandID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chestplateID")
    private Chestplate chestplateID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "armorkneepadsID")
    private ArmorKneePads armorKneePadsID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "armorbootsID")
    private ArmorBoots armorBootsID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "armorglovesID")
    private ArmorGloves armorGlovesID;

}