package com.example.formation.Entites;

import lombok.*;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Appels {
    private Long ssid;
    private Date date;
    private Date date_debut;
    private Date date_fin;
    private  Long Nb_presensence ;



}
