package com.example.formation.repository;

import com.example.formation.Entites.SeanceCours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourRepository extends JpaRepository<SeanceCours, Long> {
}
