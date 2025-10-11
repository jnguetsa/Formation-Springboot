package entites;

import java.util.Date;

public class UE {
    private int id;
    private  String nom;
    private String code;
    private Date nb_heure;
    private Date credit;

    public UE(String code, Date credit, int id, Date nb_heure, String nom) {
        this.code = code;
        this.credit = credit;
        this.id = id;
        this.nb_heure = nb_heure;
        this.nom = nom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getCredit() {
        return credit;
    }

    public void setCredit(Date credit) {
        this.credit = credit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getNb_heure() {
        return nb_heure;
    }

    public void setNb_heure(Date nb_heure) {
        this.nb_heure = nb_heure;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
