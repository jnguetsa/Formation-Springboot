package com.example.formation.repository;

import com.example.formation.Entites.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository  extends JpaRepository<Utilisateur, Long> {
}
