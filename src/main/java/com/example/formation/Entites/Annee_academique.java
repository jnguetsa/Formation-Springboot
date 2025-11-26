package com.example.formation.Entites;

import jakarta.persistence.*;
import lombok.*;


import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="annee_academique")
public class Annee_academique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String nom;
    private Date date_debut;
    private Date date_fin;
}
