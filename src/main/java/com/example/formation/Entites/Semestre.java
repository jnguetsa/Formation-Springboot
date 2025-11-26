package com.example.formation.Entites;

import com.example.formation.enums.Num_semestre;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Semestre {
    private  int id;
    private Num_semestre semestre;
    private Date date_debut;
    private Date date_fin;

}
//1FQCOMJH9J8@2025