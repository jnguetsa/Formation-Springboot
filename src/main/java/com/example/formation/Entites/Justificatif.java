package com.example.formation.Entites;

import com.example.formation.enums.StatutJustificatif;
import com.example.formation.enums.TypeJustificatif;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

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
    private Data DateDecision;
    private String Commentaire;




}
