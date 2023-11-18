package com.example.knightapi.repository;

import com.example.knightapi.models.ItemInHand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemInHandRepository extends JpaRepository<ItemInHand, Integer> {
    Optional<ItemInHand> findItemInHandByName(String name);
}
