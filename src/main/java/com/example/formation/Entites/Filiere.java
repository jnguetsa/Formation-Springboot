package com.example.formation.Entites;

import jakarta.persistence.*;
import lombok.*;

import javax.annotation.processing.Generated;
import java.util.ArrayList;
import java.util.Collection;

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
    @OneToMany(mappedBy = "filiere")
    private Collection<Etudiant> etudiant;
    @ManyToMany(mappedBy = "filiere")
    private  Collection<Cycle> cycles;

}
