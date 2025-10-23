package com.example.formation.entites;

import jakarta.persistence.Entity;
import enums.TypeNiveau;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cycle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private TypeNiveau niveau;
    private String  specialite;
}
