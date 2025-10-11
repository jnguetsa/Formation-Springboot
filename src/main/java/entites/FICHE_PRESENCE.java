package entites;

import java.util.Date;

public class FICHE_PRESENCE {
    private int id;
    private Date date;
    private Date date_debut;
    private Date date_fin;

    public FICHE_PRESENCE(Date date, Date date_debut, Date date_fin, int id) {
        this.date = date;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
}
