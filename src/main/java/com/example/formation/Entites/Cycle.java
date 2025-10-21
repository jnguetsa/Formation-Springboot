package entites;

import jakarta.persistence.Entity;
import enums.TypeNiveau;
@Entity
public class Cycle {
    private  int id;
    private TypeNiveau niveau;
    private String  specialite;
}
