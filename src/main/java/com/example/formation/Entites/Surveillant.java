package com.example.formation.Entites;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@Entity

public class Surveillant extends  Utilisateur {
    @ManyToMany(mappedBy = "surveillant")
    private Collection<Appels> appels= new ArrayList<>();
}
