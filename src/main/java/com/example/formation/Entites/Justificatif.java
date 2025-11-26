package com.example.formation.Entites;

import com.example.formation.enums.StatutJustificatif;
import com.example.formation.enums.TypeJustificatif;
import jakarta.persistence.Entity;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Justificatif {
    private int id;
    private String contenu;
    private StatutJustificatif status;
    private TypeJustificatif justificatif ;




}
