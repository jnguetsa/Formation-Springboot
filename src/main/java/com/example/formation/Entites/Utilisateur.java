package com.example.formation.Entites;

import com.example.formation.enums.TypeSexe;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String Nom;
    protected String Email;
    protected String Telephone;
    protected  String MotDePasse;
    protected TypeSexe Sexe;
    protected Boolean Active;
    protected Date Date_creation;



}