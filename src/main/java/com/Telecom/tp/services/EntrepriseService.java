package com.Telecom.tp.services;

import com.Telecom.tp.entities.Departement;
import com.Telecom.tp.entities.Entreprise;

import java.util.List;

public interface EntrepriseService {

    public int ajouterEntreprise(Entreprise entreprise);

    public int ajouterDepartement(Departement dep);

    void affecterDepartementAEntreprise(int depId, int entrepriseId);

    List<String> getAllDepartementsNamesByEntreprise(int entrepriseId);

    public void deleteEntrepriseById(int entrepriseId);

    public void deleteDepartementById(int depId);

    public Entreprise getEntrepriseById(int entrepriseId);
}
