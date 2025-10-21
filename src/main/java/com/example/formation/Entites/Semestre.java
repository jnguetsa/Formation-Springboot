package com.example.formation.entites;

import jakarta.persistence.Entity;
import enums.Num_semestre;

import java.util.Date;
@Entity
public class Semestre {
    private  int id;
    private Num_semestre semestre;
    private Date date_debut;
    private Date date_fin;

    public Semestre(Date date_debut, Date date_fin, int id, Num_semestre semestre) {
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.id = id;
        this.semestre = semestre;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Num_semestre getSemestre() {
        return semestre;
    }

    public void setSemestre(Num_semestre semestre) {
        this.semestre = semestre;
    }
}
//1FQCOMJH9J8@2025