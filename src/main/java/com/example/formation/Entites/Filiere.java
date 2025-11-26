package com.example.formation.Entites;

import jakarta.persistence.Entity;
import lombok.*;

import javax.annotation.processing.Generated;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Filiere {
    private int id;
    private  String nom;
    private String code;
    private String niveau;
    private  String description;


}
