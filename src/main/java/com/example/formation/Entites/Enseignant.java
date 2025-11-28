package com.example.formation.Entites;
import com.example.formation.enums.StatutEnsseignant;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@PrimaryKeyJoinColumn(name = "id")
public class Enseignant extends Utilisateur {

    private String grade;
    private String specialite;
    private StatutEnsseignant statutEnsseignant;
    @ManyToMany(mappedBy = "enseignant")
    private Collection<Appels> appels=new ArrayList<>();
    @ManyToMany(mappedBy = "enseignant")
    private  Collection<Seance_Cours> seanceCours= new ArrayList<>();
    @OneToMany(mappedBy = "enseignant")
    private Collection<ValidationPresence> validationPresence;
}