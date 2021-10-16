package com.Telecom.tp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MissionExterne extends Mission {

    private String emailFacturation;

    private float tauxJournalierMoyen;
}
