package com.example.formation.Entites;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Surveillant extends  Utilisateur {


        private String nom;
        private String email;
        private  String telephone;


    public Surveillant(int id, String nom, String email, String telephon, int id1, String email1, String nom1, String telephone) {
        super(id, nom, email, telephon);
        this.id = id1;
        this.email = email1;
        this.nom = nom1;
        this.telephone = telephone;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
