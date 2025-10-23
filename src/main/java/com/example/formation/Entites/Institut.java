package com.example.formation.Entites;

import jakarta.persistence.Entity;


public class Institut {
    private  int id;
    private  String nom;
    private  String ville;
    private  String adresse;
    private  String email;
    private  String telephone;
    private  String localite;


    public Institut(String adresse, String email, int id, String localite, String nom, String telephone, String ville) {
        this.adresse = adresse;
        this.email = email;
        this.id = id;
        this.localite = localite;
        this.nom = nom;
        this.telephone = telephone;
        this.ville = ville;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
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

    public String getLocalite() {
        return localite;
    }

    public void setLocalite(String localite) {
        this.localite = localite;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}
