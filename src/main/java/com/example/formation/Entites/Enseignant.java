package com.example.formation.Entites;
import com.example.formation.enums.StatutEnsseignant;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@PrimaryKeyJoinColumn(name = "id")
public class Enseignant extends Utilisateur {

    private String grade;
    private String specialite;
    private StatutEnsseignant statutEnsseignant;

}