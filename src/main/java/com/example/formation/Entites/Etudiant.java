package com.example.formation.Entites;

import com.example.formation.enums.TypeNiveau;
import com.example.formation.enums.TypeSexe;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;


import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Etudiant extends Utilisateur {
    private String  Matricule;
    private TypeNiveau Niveau;
    private TypeSexe Sexe;
    private boolean StatutRetard;
    private Date Date_naissance;

}

