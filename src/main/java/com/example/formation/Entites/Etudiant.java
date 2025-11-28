package com.example.formation.Entites;

import com.example.formation.enums.TypeNiveau;
import com.example.formation.enums.TypeSexe;
import jakarta.persistence.*;
import lombok.*;


import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Etudiant extends Utilisateur {
    private String  Matricule;
    private TypeNiveau Niveau;
    private TypeSexe Sexe;
    private boolean StatutRetard;
    private Date Date_naissance;
    @ManyToOne
    private Filiere filiere;
    @ManyToOne
    private Appels appels;
    @ManyToOne
    private  Parent parent;

}

