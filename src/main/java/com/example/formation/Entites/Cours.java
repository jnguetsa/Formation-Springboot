package com.example.formation.Entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cours {
    private  int id ;
    private  String titre;
    private int  nb_heure;
    private  int nb_credit;

}
