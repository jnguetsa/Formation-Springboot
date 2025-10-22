package com.example.formation.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;
public class Cours {
    private  int id ;
    private  String titre;
    private int  nb_heure;
    private  int nb_credit;

    public Cours(int id, int nb_credit, int nb_heure, String titre) {
        this.id = id;
        this.nb_credit = nb_credit;
        this.nb_heure = nb_heure;
        this.titre = titre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNb_credit() {
        return nb_credit;
    }

    public void setNb_credit(int nb_credit) {
        this.nb_credit = nb_credit;
    }

    public int getNb_heure() {
        return nb_heure;
    }

    public void setNb_heure(int nb_heure) {
        this.nb_heure = nb_heure;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
}
