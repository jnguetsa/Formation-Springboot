package com.example.formation.Entites;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Institut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String nom;
    private  String ville;
    private  String adresse;
    private  String email;
    private  String telephone;
    private  String localite;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Utilisateur> utilisateur= new ArrayList<>();
    @OneToMany(mappedBy = "institut")
    private Collection<Ecole> ecole;

}
