package com.example.formation.Entites;

public class Utilisateur {

    protected int id;
    protected String nom;
    protected String email;
    protected String telephon;


    public Utilisateur(int id,  String nom, String email,  String telephon) {
        this.email = email;
        this.id = id;
        this.nom = nom;
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
