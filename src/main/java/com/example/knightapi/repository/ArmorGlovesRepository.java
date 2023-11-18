package com.example.knightapi.repository;

import com.example.knightapi.models.ArmorGloves;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArmorGlovesRepository extends JpaRepository<ArmorGloves, Integer> {
    Optional<ArmorGloves> findArmorGlovesByName(String name);

}
