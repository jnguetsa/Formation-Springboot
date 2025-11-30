package com.example.formation.Entites;
import java.util.ArrayList;
import java.util.Collection;

import com.example.formation.enums.GradeEnsei;
import com.example.formation.enums.StatutEnsseignant;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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

    private GradeEnsei grade;
    private String specialite;

    private StatutEnsseignant statutEnsseignant;
    @ManyToMany(mappedBy = "enseignant")
    private Collection<Appels> appels=new ArrayList<>();
    @ManyToMany(mappedBy = "enseignant")
    private  Collection<SeanceCours> seanceCours= new ArrayList<>();
    @OneToMany(mappedBy = "enseignant")
    private Collection<ValidationPresence> validationPresence;
}