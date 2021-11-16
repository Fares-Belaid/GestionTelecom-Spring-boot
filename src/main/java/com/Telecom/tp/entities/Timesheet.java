package com.Telecom.tp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Timesheet {

    @EmbeddedId
    private TimesheetPK timesheetPK;

    private boolean isValid;

    @ManyToOne
    private Employe employe;

    @ManyToOne
    private Mission mission;
}
