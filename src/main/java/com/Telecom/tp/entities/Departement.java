package com.Telecom.tp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Departement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany
    public List<Employe> employes;

    @OneToMany(mappedBy = "departement")
    private List<Mission> missions;

    @ManyToOne
    private Entreprise entreprise;

}
