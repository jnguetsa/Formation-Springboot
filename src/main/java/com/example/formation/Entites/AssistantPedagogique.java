package com.example.formation.Entites;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class AssistantPedagogique extends Utilisateur {

    @ManyToOne
    private Ecole ecoleCollection;
    @OneToMany(mappedBy = "assistantPedagogique")
    private Collection<Appels> appels;
    @OneToMany(mappedBy = "assistantPedagogique")
    private Collection<Justificatif> justificatif;
}
