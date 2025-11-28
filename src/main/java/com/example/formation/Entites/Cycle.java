package com.example.formation.Entites;

import com.example.formation.enums.TypeNiveau;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;


@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Cycle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private TypeNiveau niveau;
    private String  specialite;
    @ManyToOne
    private Filiere filiere;
    @ManyToOne
    private Ecole ecole;
}
