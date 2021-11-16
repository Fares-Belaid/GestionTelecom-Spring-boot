package com.Telecom.tp.services.impl;

import com.Telecom.tp.entities.Departement;
import com.Telecom.tp.entities.Entreprise;
import com.Telecom.tp.repository.DepartementRepository;
import com.Telecom.tp.repository.EntrepriseRepository;
import com.Telecom.tp.services.EntrepriseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EntrepriseServiceImpl implements EntrepriseService {

    @Autowired
    private EntrepriseRepository entrepriseRepository;

    @Autowired
    private DepartementRepository departementRepository;


    @Override
    public int ajouterEntreprise(Entreprise entreprise) {
         entrepriseRepository.save(entreprise);
         return entreprise.getId();
    }

    @Override
    public int ajouterDepartement(Departement dep) {
        departementRepository.save(dep);
        return dep.getId();
    }

    @Override
    public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
        Entreprise entreprise = entrepriseRepository.findById(entrepriseId).get();
        Departement departement = departementRepository.findById(depId).get();

        departement.setEntreprise(entreprise);
        departementRepository.save(departement);
    }

    @Override
    public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
        Entreprise entreprise = entrepriseRepository.findById(entrepriseId).get();

        List<String> deptNames= new ArrayList<>();

        for (Departement dept : entreprise.getDepartements()){
            deptNames.add(dept.getName());
        }

        return deptNames;
    }

    @Override
    public void deleteEntrepriseById(int entrepriseId) {
        Entreprise entreprise = entrepriseRepository.findById(entrepriseId).get();
        entrepriseRepository.delete(entreprise);
    }

    @Override
    public void deleteDepartementById(int depId) {
        Departement departement = departementRepository.findById(depId).get();
        departementRepository.delete(departement);
    }

    @Override
    public Entreprise getEntrepriseById(int entrepriseId) {
        Entreprise entreprise = entrepriseRepository.findById(entrepriseId).get();
        return entreprise;
    }
}
