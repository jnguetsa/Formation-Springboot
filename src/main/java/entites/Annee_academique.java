package entites;

import springboot_25_26_ING_3_ISI_FR_groupe_5.enums.Num_semestre;

import java.util.Date;

public class Annee_academique {
    private  int id;
    private  String nom;
    private Date date_debut;
    private Date date_fin;

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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Annee_academique(Date date_debut, Date date_fin, int id, String nom) {
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.id = id;
        this.nom = nom;


    }
}
