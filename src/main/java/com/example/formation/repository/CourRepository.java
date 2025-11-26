package com.example.formation.repository;

import com.example.formation.Entites.Cours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourRepository extends JpaRepository<Cours, Long> {
}
