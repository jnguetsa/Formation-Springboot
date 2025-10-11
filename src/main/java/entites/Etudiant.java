package springboot_25_26_ING_3_ISI_FR_groupe_5.entites;

import springboot_25_26_ING_3_ISI_FR_groupe_5.enums.TypeNiveau;
import springboot_25_26_ING_3_ISI_FR_groupe_5.enums.TypeSexe;

import java.util.Date;

public class Etudiant {
    private  int id;
    private String nom;
    private String prenom;
    private String email;
    private String adresse;
    private String telephone;
    private String  matricule;
    private TypeNiveau niveau;
    private  TypeSexe sexe;

    private Date date_naissance;

    public Etudiant(String adresse, Date date_naissance, String email, int id, String matricule, TypeNiveau niveau, String nom, String prenom, TypeSexe sexe, String telephone) {
        this.adresse = adresse;
        this.date_naissance = date_naissance;
        this.email = email;
        this.id = id;
        this.matricule = matricule;
        this.niveau = niveau;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.telephone = telephone;
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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}

