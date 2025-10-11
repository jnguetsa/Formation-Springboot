package entites;

public class Ecole {

    private  int id;
    private  String nom;
    private  String adresse;
    private  String email;
    private  String telephone;

    public Ecole(String adresse, String email, int id, String nom, String telephone) {
        this.adresse = adresse;
        this.email = email;
        this.id = id;
        this.nom = nom;
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
