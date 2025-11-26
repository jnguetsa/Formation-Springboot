package com.example.formation.Entites;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FICHE_PRESENCE {
    private int id;
    private Date date;
    private Date date_debut;
    private Date date_fin;




}
