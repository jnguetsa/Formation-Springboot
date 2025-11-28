package com.example.formation.Entites;

import com.example.formation.enums.TypeSexe;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    protected Long id;
    protected String Nom;
    protected String Email;
    protected String Telephone;
    protected  String MotDePasse;
    protected TypeSexe Sexe;
    protected Boolean Active;
    protected Date Date_creation;
    @ManyToMany (mappedBy = "utilisateur", fetch=FetchType.EAGER)
    private Collection<Role> roles =  new ArrayList<>();
    @ManyToMany(mappedBy = "utilisateur")
    private  Collection<Institut> institutCollection= new ArrayList<>();

   @OneToMany(mappedBy = "utilisateur")
    private Collection<Localisation> localisations;

}