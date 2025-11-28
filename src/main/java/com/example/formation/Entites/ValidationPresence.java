package com.example.formation.Entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ValidationPresence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String qrcode;
    private String code_pin;
    private Date date_creation;
    @ManyToOne
    private Enseignant enseignant;
}
