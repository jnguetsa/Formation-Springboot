package entites;
public class Enseignant extends  Utilisateur {

    private String grade;
    private String specialite;

    public Enseignant(int id, String nom, String email, String telephon, String grade, String specialite) {
        super(id, nom, email, telephon);
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
