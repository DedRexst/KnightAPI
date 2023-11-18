package com.example.knightapi.repository;

import com.example.knightapi.models.Chestplate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChestplateRepository extends JpaRepository<Chestplate, Integer> {
    Optional<Chestplate> findChestplateByName(String name);

}
