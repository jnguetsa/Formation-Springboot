package com.example.formation.Entites;

import com.example.formation.enums.StatutJustificatif;
import com.example.formation.enums.TypeJustificatif;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Justificatif {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contenu;
    private StatutJustificatif status;
    private TypeJustificatif justificatif ;
    private Date DateDecision;
    private String Commentaire;

    @ManyToOne
    private AssistantPedagogique assistantPedagogique;
    @OneToMany(mappedBy = "justificatif")
    private Collection<SeanceCours> seance;
    @ManyToMany(mappedBy = "justificatif")
    private  Collection<Fichier> fichier= new ArrayList<>();
}
