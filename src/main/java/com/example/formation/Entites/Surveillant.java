package com.example.formation.Entites;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@PrimaryKeyJoinColumn(name = "id")
public class Surveillant extends  Utilisateur {
}
