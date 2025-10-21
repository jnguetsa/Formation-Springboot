package com.example.formation.entites;

import jakarta.persistence.Entity;

@Entity
public class AssistantPedagogique {
    private  int id;
    private String nom;
    private String email;

    public AssistantPedagogique(String email, int id, String nom) {
        this.email = email;
        this.id = id;
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
