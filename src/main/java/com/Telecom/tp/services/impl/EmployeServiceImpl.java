package com.Telecom.tp.services.impl;

import com.Telecom.tp.entities.*;
import com.Telecom.tp.repository.ContratRepository;
import com.Telecom.tp.repository.DepartementRepository;
import com.Telecom.tp.repository.EmployeRepository;
import com.Telecom.tp.repository.TimesheetRepository;
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

    @Autowired
    private TimesheetRepository timesheetRepository;

    @Override
    public int ajouterEmploye(Employe employe) {
        employeRepository.save(employe);
        return employe.getId();
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

        Departement departement = departementRepository.findById(depId).get();
        int employeNB = departement.getEmployes().size();

        for (int i =0; i< employeNB; i++ ){
            if (departement.getEmployes().get(i).getId() == employeId){
                departement.getEmployes().remove(i);
            }
            break;
        }
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
        Employe employe = employeRepository.findById(employeId).get();

        for(Departement dep : employe.getDepartements()){
            dep.getEmployes().remove(employe);
        }

        employeRepository.delete(employe);

    }

    @Override
    public void deleteContratById(int contratId) {

        Contrat contrat = contratRepository.findById(contratId).get();
        contratRepository.delete(contrat);
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
        return employeRepository.getAllEmployeByEntreprise(entreprise);
    }

    @Override
    public void mettreAjourEmailByEmployeIdJPQL(String email, int employeId) {
            employeRepository.mettreAjourEmailByEmployeId(email,employeId);
    }

    @Override
    public void deleteAllContratJPQL() {
            employeRepository.deleteAllContratJPQL();
    }

    @Override
    public float getSalaireByEmployeIdJPQL(int employeId) {
       return employeRepository.getSalaireByEmployeIdJPQL(employeId);

    }

    @Override
    public Double getSalaireMoyenByDepartementId(int departementId) {
        return employeRepository.getSalaireMoyenByDepartementId(departementId);
    }

    @Override
    public List<Employe> getAllEmployes() {
        return employeRepository.findAll();
    }

    @Override
    public List<Timesheet> getTimesheetsByMissionAndDate(Employe employe, Mission mission, Date dateDebut, Date dateFin) {
        return timesheetRepository.getTimesheetsByMissionAndDate(employe,mission,dateDebut,dateFin);
    }

    @Override
    public int addOrUpdateEmploye(Employe employe) {
        employeRepository.save(employe);
        return 0;
    }

    @Override
    public List<Mission> findAllMissionByEmployeJPQL(int employeId) {
        return timesheetRepository.findAllMissionByEmployeJPQL(employeId);
    }

    @Override
    public List<Employe> getAllEmployeByMission(int missionId) {
        return timesheetRepository.getAllEmployeByMission(missionId);
    }
}
