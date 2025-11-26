package com.example.formation.Entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Appels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ssid;
    private Date date;
    private Date date_debut;
    private Date date_fin;
    private  Long Nb_presensence ;



}
