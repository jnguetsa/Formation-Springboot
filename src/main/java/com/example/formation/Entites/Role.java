package com.example.formation.Entites;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private String description;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
    private Collection<Permission> permissions = new ArrayList<>();
    @ManyToMany(fetch = FetchType.EAGER)
    private  Collection<Utilisateur> utilisateur=new ArrayList<>();
}