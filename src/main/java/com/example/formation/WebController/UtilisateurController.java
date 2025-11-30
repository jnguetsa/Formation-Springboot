package com.example.formation.WebController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.formation.Entites.Utilisateur;
import com.example.formation.repository.UtilisateurRepository;

@Controller
public class UtilisateurController {

    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @GetMapping("/user")
    public String users(Model model){
        List<Utilisateur> utilisateurs= utilisateurRepository.findAll();
        return"utilisateur";
    }
}
