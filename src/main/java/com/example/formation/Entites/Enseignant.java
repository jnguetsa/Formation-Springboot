package com.example.formation.Entites;

import jakarta.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Enseignant extends Utilisateur {

    private String grade;
    private String specialite;

    // Constructeur par défaut requis par JPA
    public Enseignant() {
        super();
    }

    public Enseignant(String nom, String email, String telephone, String grade, String specialite) {
        super(nom, email, telephone);
        this.grade = grade;
        this.specialite = specialite;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
}