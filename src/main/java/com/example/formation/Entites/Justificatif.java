package entites;

import jakarta.persistence.Entity;
import enums.StatutJustificatif;
import enums.TypeJustificatif;
@Entity
public class Justificatif {
    private int id;
    private String contenu;
    private  StatutJustificatif status;
    private TypeJustificatif  justificatif ;

    public Justificatif(String contenu, int id, TypeJustificatif justificatif, StatutJustificatif status) {
        this.contenu = contenu;
        this.id = id;
        this.justificatif = justificatif;
        this.status = status;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TypeJustificatif getJustificatif() {
        return justificatif;
    }

    public void setJustificatif(TypeJustificatif justificatif) {
        this.justificatif = justificatif;
    }

    public StatutJustificatif getStatus() {
        return status;
    }

    public void setStatus(StatutJustificatif status) {
        this.status = status;
    }
}
