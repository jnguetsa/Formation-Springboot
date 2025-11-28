package com.example.formation.Entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.cdi.Eager;

import java.util.Collection;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ecole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String email;
    private String adresse;
    private String telephone;
    private Date date_creation;
    @OneToMany(mappedBy = "ecoleCollection")
    private Collection<AssistantPedagogique> assistantPedagogiques;
    @ManyToOne
    private Institut institut;
    @OneToMany(mappedBy = "ecole")
    private  Collection<Cycle> cycles;
}
