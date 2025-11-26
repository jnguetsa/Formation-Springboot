package com.example.formation.Entites;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UE {
    private int id;
    private String nom;
    private String code;
    private Date nb_heure;
    private Date credit;

}
