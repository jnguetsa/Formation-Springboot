package com.example.formation.Entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AssistantPedagogique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String nom;
    private String email;

    public AssistantPedagogique(String email, int id, String nom) {
        this.email = email;

        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
