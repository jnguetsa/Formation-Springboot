package com.example.formation.Entites;

import com.example.formation.enums.TypeNiveau;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Cycle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private TypeNiveau niveau;
    private String  specialite;
}
