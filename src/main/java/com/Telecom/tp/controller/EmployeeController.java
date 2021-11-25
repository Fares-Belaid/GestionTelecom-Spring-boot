package com.Telecom.tp.controller;

import com.Telecom.tp.entities.Contrat;
import com.Telecom.tp.entities.Employe;
import com.Telecom.tp.entities.Entreprise;
import com.Telecom.tp.services.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeService employeService;

    @PostMapping("/ajouter")
    public Employe ajouterEmploye(@RequestBody Employe employe){
        employeService.ajouterEmploye(employe);
        return employe;
    }

    @PutMapping("/affecterEmpDept/{employeId}/{depId}")
    public void affecterEmployeADepartement(@PathVariable("employeId") int employeId,@PathVariable("depId") int depId){
        employeService.affecterEmployeADepartement(employeId,depId);
    }

    @PutMapping("/modifierEmail/{employeId}")
    public void mettreAjourEmailByEmployeId(@RequestBody String email,@PathVariable("employeId") int employeId){
        employeService.mettreAjourEmailByEmployeIdJPQL(email, employeId);
    }

    @PutMapping("/desaffecterEmpDept/{employeId}/{depId}")
    public void desaffecterEmployeDuDepartement(@PathVariable("employeId") int employeId,@PathVariable("depId") int depId){
        employeService.desaffecterEmployeDuDepartement(employeId,depId);
    }

    @PostMapping("/ajouterContrat")
    public Contrat ajouterContrat(@RequestBody Contrat contrat){
        employeService.ajouterContrat(contrat);
        return contrat;
    }

    @PutMapping("/affecterContratEmp/{contratId}/{employeId}")
    public void affecterContratAEmploye(@PathVariable("contratId") int contratId,@PathVariable("employeId") int employeId){
        employeService.affecterContratAEmploye(contratId,employeId);
    }

    @GetMapping("/getemployeePrenomById/{employeId}")
    public String getEmployePrenomById(@PathVariable("employeId") int employeId){
        return employeService.getEmployePrenomById(employeId);
    }

    @DeleteMapping("/deleteEmp/{employeId}")
    public void deleteEmployeById(@PathVariable("employeId") int employeId){
        employeService.deleteEmployeById(employeId);
    }

    @DeleteMapping("/deleteEmp/{contratId}")
    public void deleteContratById(@PathVariable("employeId") int contratId){
        employeService.deleteContratById(contratId);
    }

    @GetMapping("/getNombreEmploye")
    public long getNombreEmploye(){
        return employeService.getNombreEmployeJPQL();
    }

    @GetMapping("/getAllEmployeNames")
    public List<String> getAllEmployeNames(){
        return employeService.getAllEmployeNamesJPQL();
    }

    @GetMapping("/getAllEmployeByEntreprise")
    public List<Employe> getAllEmployeByEntreprise(Entreprise entreprise){
        return employeService.getAllEmployeByEntreprise(entreprise);
    }

    //TODO les autres sevices
}
