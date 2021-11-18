package com.Telecom.tp.services.impl;

import com.Telecom.tp.entities.*;
import com.Telecom.tp.repository.ContratRepository;
import com.Telecom.tp.repository.DepartementRepository;
import com.Telecom.tp.repository.EmployeRepository;
import com.Telecom.tp.services.EmployeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class EmployeServiceImpl implements EmployeService {

    @Autowired
    private EmployeRepository employeRepository;

    @Autowired
    private DepartementRepository departementRepository;

    @Autowired
    private ContratRepository contratRepository;


    @Override
    public int ajouterEmploye(Employe employe) {
        employeRepository.save(employe);
        return employe.getId();
    }

    @Override
    public void mettreAjourEmailByEmployeId(String email, int employeId) {

    }

    @Override
    public void affecterEmployeADepartement(int employeId, int depId) {
        Employe employe = employeRepository.findById(employeId).get();
        Departement departement = departementRepository.findById(depId).get();

        if (departement.getEmployes()== null){
            List<Employe> employes = new ArrayList<>();
            employes.add(employe);
            departement.setEmployes(employes);
        }else {
            departement.getEmployes().add(employe);
        }
    }

    @Override
    public void desaffecterEmployeDuDepartement(int employeId, int depId) {

    }

    @Override
    public int ajouterContrat(Contrat contrat) {
       contratRepository.save(contrat);
       return contrat.getReference();
    }

    @Override
    public void affecterContratAEmploye(int contratId, int employeId) {
        Contrat contrat = contratRepository.findById(contratId).get();
        Employe employe = employeRepository.findById(employeId).get();

       contrat.setEmploye(employe);
       contratRepository.save(contrat);

    }

    @Override
    public String getEmployePrenomById(int employeId) {
        Employe employe = employeRepository.findById(employeId).get();
        return employe.getPrenom();
    }

    @Override
    public void deleteEmployeById(int employeId) {

    }

    @Override
    public void deleteContratById(int contratId) {

    }

    @Override
    public long getNombreEmployeJPQL() {
        return employeRepository.countEmp();
    }

    @Override
    public List<String> getAllEmployeNamesJPQL() {
        return employeRepository.employeNames();
    }

    @Override
    public List<Employe> getAllEmployeByEntreprise(Entreprise entreprise) {
        return null;
    }

    @Override
    public void mettreAjourEmailByEmployeIdJPQL(String email, int employeId) {

    }

    @Override
    public void deleteAllContratJPQL() {

    }

    @Override
    public float getSalaireByEmployeIdJPQL(int employeId) {
        return 0;
    }

    @Override
    public Double getSalaireMoyenByDepartementId(int departementId) {
        return null;
    }

    @Override
    public List<Employe> getAllEmployes() {
        return null;
    }

    @Override
    public List<Timesheet> getTimesheetsByMissionAndDate(Employe employe, Mission mission, Date dateDebut, Date dateFin) {
        return null;
    }

    @Override
    public int addOrUpdateEmploye(Employe employe) {
        return 0;
    }
}
