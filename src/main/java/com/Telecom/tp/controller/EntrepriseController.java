package com.Telecom.tp.controller;

import com.Telecom.tp.entities.Departement;
import com.Telecom.tp.entities.Entreprise;
import com.Telecom.tp.services.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entrprise")
public class EntrepriseController {

    @Autowired
    EntrepriseService entrepriseService;

    @PostMapping("/ajouterEntreprise")
    public int ajouterEntreprise(@RequestBody Entreprise entreprise){
       return entrepriseService.ajouterEntreprise(entreprise);
    }

    @PostMapping("/ajouterDepartement")
    public int ajouterDepartement(@RequestBody Departement dep){
        return entrepriseService.ajouterDepartement(dep);
    }

    //TODO les autres services
}
