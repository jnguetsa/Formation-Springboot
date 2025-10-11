package springboot_25_26_ING_3_ISI_FR_groupe_5.entites;

import javax.annotation.processing.Generated;


public class Filiere {
    private int id;
    private  String nom;
    private String code;
    private String niveau;
    private  String description;

    public Filiere(String code, String description, int id, String niveau, String nom) {
        this.code = code;
        this.description = description;
        this.id = id;
        this.niveau = niveau;
        this.nom = nom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
