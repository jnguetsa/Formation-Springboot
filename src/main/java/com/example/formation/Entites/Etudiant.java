package com.example.formation.Entites;

import com.example.formation.enums.TypeNiveau;
import com.example.formation.enums.TypeSexe;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


import java.util.Date;
@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Etudiant extends Utilisateur {


    private String prenom;
    private String adresse;

    private String  matricule;
    private TypeNiveau niveau;
    private TypeSexe sexe;

    private Date date_naissance;

}

