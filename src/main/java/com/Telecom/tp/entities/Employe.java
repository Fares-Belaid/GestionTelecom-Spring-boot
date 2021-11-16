package com.Telecom.tp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String prenom;

    private String nom;

    private String email;

    private boolean isActif;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne(mappedBy = "employe")
    private Contrat contrat;

    @OneToMany(mappedBy = "employe")
    private List<Timesheet> timesheets;

    @ManyToMany(mappedBy = "employes")
    private List<Departement> departements;


}
