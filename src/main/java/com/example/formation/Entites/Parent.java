package com.example.formation.Entites;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.Collection;


@Entity
public class Parent extends Utilisateur {
    @OneToMany(mappedBy = "parent" , fetch = FetchType.EAGER)
    private Collection<Etudiant> etudiants;


}


