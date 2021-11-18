package com.Telecom.tp.repository;

import com.Telecom.tp.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeRepository extends JpaRepository<Employe, Integer> {

    @Query("SELECT COUNT (e) from Employe e ")
    public long countEmp();

    @Query("SELECT nom from Employe ")
    public List<String> employeNames();
}
