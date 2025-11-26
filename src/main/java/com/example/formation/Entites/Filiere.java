package com.example.formation.Entites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import javax.annotation.processing.Generated;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Filiere {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String nom;
    private String code;
    private String niveau;
    private  String description;


}
