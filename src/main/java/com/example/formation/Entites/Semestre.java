package com.example.formation.Entites;

import com.example.formation.enums.Num_semestre;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Semestre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private Num_semestre semestre;
    private Date date_debut;
    private Date date_fin;
    @ManyToMany
    private Collection<Seance_Cours> seanceCours= new ArrayList<>();
    @ManyToOne
    private Annee_academique anneeAcademique;


}
