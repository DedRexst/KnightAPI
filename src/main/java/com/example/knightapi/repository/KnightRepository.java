package com.example.knightapi.repository;

import com.example.knightapi.models.Knight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KnightRepository extends JpaRepository<Knight, Integer> {
}
