package com.Telecom.tp.repository;

import com.Telecom.tp.entities.Employe;
import com.Telecom.tp.entities.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeRepository extends JpaRepository<Employe, Integer> {

    @Query("SELECT COUNT (e) from Employe e ")
    public long countEmp();

    @Query("SELECT nom from Employe ")
    public List<String> employeNames();

    @Query("select (emp) from Employe emp " +
            "join emp.departements dpt"
            + " join dpt.entreprise entrep "
            + "where entrep=:entreprise")
    List<Employe> getAllEmployeByEntreprise(@Param("entreprise") Entreprise entreprise);

    @Query("UPDATE Employe e set e.email=: email where e.id=: employeId")
    public void mettreAjourEmailByEmployeId(@Param("email") String email, @Param("employeId") int employeId);

    @Query("delete from Contrat ")
    public void deleteAllContratJPQL();

    @Query("select c.salaire from Contrat c" +
            " join c.employe e where e.id=: employeId")
    public float getSalaireByEmployeIdJPQL(@Param("employeId") int employeId);

    @Query("select avg (c.salaire) from Contrat c " +
            " join c.employe emp" +
            " join emp.departements dpt" +
            " where dpt.id=: departementId")
    public Double getSalaireMoyenByDepartementId(@Param("departementId") int departementId);
}
