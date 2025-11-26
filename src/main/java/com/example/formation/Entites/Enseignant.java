package com.example.formation.Entites;
import com.example.formation.enums.StatutEnsseignant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@EqualsAndHashCode(callSuper = true)
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