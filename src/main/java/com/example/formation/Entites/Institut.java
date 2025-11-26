package com.example.formation.Entites;

import jakarta.persistence.Entity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Institut {
    private  int id;
    private  String nom;
    private  String ville;
    private  String adresse;
    private  String email;
    private  String telephone;
    private  String localite;

}
