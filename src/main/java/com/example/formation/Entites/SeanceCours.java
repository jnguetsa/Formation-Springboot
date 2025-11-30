package com.example.formation.Entites;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SeanceCours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id ;
    private  String titre;
    private int  nb_heure;
    private  int nb_credit;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Semestre> semestre=new ArrayList<>();
    @ManyToOne
    private Appels appels;
    @ManyToMany
    private Collection<Enseignant> enseignant= new ArrayList<>();
    @ManyToOne
    private Justificatif justificatif;
    @ManyToOne
    private  UE ue;
}
