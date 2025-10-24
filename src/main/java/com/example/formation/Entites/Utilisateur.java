package com.example.formation.Entites;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    protected String nom;
    protected String email;
    protected String telephon;

    // ⭐⭐ CONSTRUCTEUR SANS ARGUMENT (déjà présent - à garder) ⭐⭐
    public Utilisateur() {
    }

    // ⭐⭐ AJOUT : NOUVEAU CONSTRUCTEUR SANS ID ⭐⭐
    public Utilisateur(String nom, String email, String telephon) {
        this.nom = nom;
        this.email = email;
        this.telephon = telephon;
    }

    // ⭐⭐ ANCIEN CONSTRUCTEUR AVEC ID (à garder pour compatibilité) ⭐⭐
    public Utilisateur(int id, String nom, String email, String telephon) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.telephon = telephon;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephon() {
        return telephon;
    }

    public void setTelephon(String telephon) {
        this.telephon = telephon;
    }
}