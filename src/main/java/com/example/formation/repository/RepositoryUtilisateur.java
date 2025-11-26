package com.example.formation.repository;

import com.example.formation.Entites.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryUtilisateur extends JpaRepository<Utilisateur, Long>{
}
