package com.example.formation.Entites;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Localisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private  Long id;
        private int Longitude;
        private  int Latitude;
        private Date Date;
@ManyToOne
    private Utilisateur utilisateur;
}
