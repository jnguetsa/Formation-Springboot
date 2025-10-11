package springboot_25_26_ING_3_ISI_FR_groupe_5.entites;
public class Enseignant {
    private  int id;
    private String nom;
    private String email;
    private String grade;
    private String specialite;

    public Enseignant(String email, String grade, int id, String nom, String specialite) {
        this.email = email;
        this.grade = grade;
        this.id = id;
        this.nom = nom;
        this.specialite = specialite;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
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

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
}
