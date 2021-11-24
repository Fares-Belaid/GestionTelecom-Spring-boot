package com.Telecom.tp.services;

import com.Telecom.tp.entities.*;

import java.util.Date;
import java.util.List;

public interface EmployeService {

    public int ajouterEmploye(Employe employe);

    public void affecterEmployeADepartement(int employeId, int depId);

    public void desaffecterEmployeDuDepartement(int employeId, int depId);

    public int ajouterContrat(Contrat contrat);

    public void affecterContratAEmploye(int contratId, int employeId);

    public String getEmployePrenomById(int employeId);

    public void deleteEmployeById(int employeId);

    public void deleteContratById(int contratId);

    public long getNombreEmployeJPQL();

    public List<String> getAllEmployeNamesJPQL();

    public List<Employe> getAllEmployeByEntreprise(Entreprise entreprise);

    public void mettreAjourEmailByEmployeIdJPQL(String email, int employeId);

    public void deleteAllContratJPQL();

    public float getSalaireByEmployeIdJPQL(int employeId);

    public Double getSalaireMoyenByDepartementId(int departementId);

    public List<Employe> getAllEmployes();

    public List<Timesheet> getTimesheetsByMissionAndDate(Employe employe, Mission mission,Date dateDebut, Date dateFin);

    int addOrUpdateEmploye(Employe employe);

    public List<Mission> findAllMissionByEmployeJPQL(int employeId);

    public List<Employe> getAllEmployeByMission(int missionId);


}
