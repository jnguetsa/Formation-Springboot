package com.example.formation.repository;

import com.example.formation.Entites.Seance_Cours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourRepository extends JpaRepository<Seance_Cours, Long> {
}
