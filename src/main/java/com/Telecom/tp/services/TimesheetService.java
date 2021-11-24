package com.Telecom.tp.services;

import com.Telecom.tp.entities.Employe;
import com.Telecom.tp.entities.Mission;

import java.util.Date;
import java.util.List;

public interface TimesheetService {

    public int ajouterMission(Mission mission);

    public void affecterMissionADepartement(int missionId, int depId);

    public void ajouterTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin);

    public void validerTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin, int validateurId);

    public List<Mission> findAllMissionByEmployeJPQL(int employeId);

    public List<Employe> getAllEmployeByMission(int missionId);
}
