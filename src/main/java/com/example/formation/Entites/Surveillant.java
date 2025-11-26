package com.example.formation.Entites;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@PrimaryKeyJoinColumn(name = "id")
public class Surveillant extends  Utilisateur {
}
