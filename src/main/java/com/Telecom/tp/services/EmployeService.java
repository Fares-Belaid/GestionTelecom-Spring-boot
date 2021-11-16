package com.Telecom.tp.services;

import com.Telecom.tp.entities.Contrat;
import com.Telecom.tp.entities.Employe;

import java.util.List;

public interface EmployeService {

    public int ajouterEmploye(Employe employe);

    public void affecterEmployeADepartement(int employeId, int depId);

    public int ajouterContrat(Contrat contrat);

    public void affecterContratAEmploye(int contratId, int employeId);

    public String getEmployePrenomById(int employeId);

    public long getNombreEmployeJPQL();

    public List<String> getAllEmployeNamesJPQL();
}
