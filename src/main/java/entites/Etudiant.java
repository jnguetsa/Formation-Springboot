package entites;

import jakarta.persistence.Entity;
import enums.TypeNiveau;
import enums.TypeSexe;

import java.util.Date;
@Entity
public class Etudiant extends Utilisateur {

    private String prenom;
    private String adresse;

    private String  matricule;
    private TypeNiveau niveau;
    private  TypeSexe sexe;

    private Date date_naissance;

    public Etudiant(int id, String nom, String email, String telephon, String adresse, Date date_naissance, String matricule, TypeNiveau niveau, String prenom, TypeSexe sexe) {
        super(id, nom, email, telephon);
        this.adresse = adresse;
        this.date_naissance = date_naissance;
        this.matricule = matricule;
        this.niveau = niveau;
        this.prenom = prenom;
        this.sexe = sexe;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public TypeNiveau getNiveau() {
        return niveau;
    }

    public void setNiveau(TypeNiveau niveau) {
        this.niveau = niveau;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public TypeSexe getSexe() {
        return sexe;
    }

    public void setSexe(TypeSexe sexe) {
        this.sexe = sexe;
    }
}

