package com.Telecom.tp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TimesheetPK implements Serializable {

    private int idEmploye;

    private int idMission;
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Temporal(TemporalType.DATE)
    private Date dateFin;

    private boolean isValide;

    public TimesheetPK(int missionId, int employeId, Date dateDebut, Date dateFin) {
        super();
        this.idMission = missionId;
        this.idEmploye = employeId;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }
}
