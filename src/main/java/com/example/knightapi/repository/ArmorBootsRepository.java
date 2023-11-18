package com.example.knightapi.repository;

import com.example.knightapi.models.ArmorBoots;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArmorBootsRepository extends JpaRepository<ArmorBoots, Integer> {
    Optional<ArmorBoots> findArmorBootsByName(String name);
}
