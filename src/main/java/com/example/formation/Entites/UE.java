package com.example.formation.Entites;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String code;
    private Date nb_heure;
    private int credit;
    private Date Date_creation;
    @OneToMany(mappedBy = "ue")
    private Collection<SeanceCours> seanceCours;

}
