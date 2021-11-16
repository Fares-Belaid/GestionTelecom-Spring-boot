package com.Telecom.tp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reference;

    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    private String typeContrat;

    private float salaire;

    @OneToOne
    private Employe employe;
}
