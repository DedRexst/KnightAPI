package com.example.knightapi.repository;

import com.example.knightapi.models.ArmorKneePads;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArmorKneePadsRepository extends JpaRepository<ArmorKneePads, Integer> {
    Optional<ArmorKneePads> findArmorKneePadsByName(String name);

}
