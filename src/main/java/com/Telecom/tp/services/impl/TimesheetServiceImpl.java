package com.Telecom.tp.services.impl;

import com.Telecom.tp.entities.*;
import com.Telecom.tp.repository.DepartementRepository;
import com.Telecom.tp.repository.EmployeRepository;
import com.Telecom.tp.repository.MissionRepository;
import com.Telecom.tp.repository.TimesheetRepository;
import com.Telecom.tp.services.TimesheetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class TimesheetServiceImpl implements TimesheetService {

    @Autowired
    private MissionRepository missionRepository;

    @Autowired
    private DepartementRepository departementRepository;

    @Autowired
    TimesheetRepository timesheetRepository;

    @Autowired
    EmployeRepository employeRepository;

    @Override
    public int ajouterMission(Mission mission) {
        return missionRepository.save(mission).getId();
    }

    @Override
    public void affecterMissionADepartement(int missionId, int depId) {
        Mission mission = missionRepository.getById(missionId);
        Departement departement = departementRepository.getById(depId);

        mission.setDepartement(departement);
        missionRepository.save(mission);
    }

    @Override
    public void ajouterTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin) {
        TimesheetPK timesheetPK = new TimesheetPK();
        timesheetPK.setDateDebut(dateDebut);
        timesheetPK.setDateFin(dateFin);
        timesheetPK.setIdEmploye(employeId);
        timesheetPK.setIdMission(missionId);

        Timesheet timesheet = new Timesheet();
        timesheet.setTimesheetPK(timesheetPK);
        timesheet.setValid(false); //par defaut non valide
        timesheetRepository.save(timesheet);
    }

    @Override
    public void validerTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin, int validateurId) {

        Employe validateur = employeRepository.getById(validateurId);
        Mission mission = missionRepository.getById(missionId);

        if (!validateur.getRole().equals(Role.CHEF_DEPARTEMENT)){
            System.out.println("seulement le chef de departement peut valider les missions");
            return;
        }
        boolean chefDeLaMission = false;
        for (Departement dep : validateur.getDepartements()){
            if (dep.getId() == mission.getDepartement().getId()){
                chefDeLaMission = true;
                break;
            }
        }

        if (!chefDeLaMission){
            System.out.println("l'employe doit etre chef de departement de la mission en question");
            return;
        }

        TimesheetPK timesheetPK = new TimesheetPK(missionId, employeId, dateDebut, dateFin);
        Timesheet timesheet =timesheetRepository.findBytimesheetPK(timesheetPK);
        timesheet.setValid(true);

        //Comment Lire une date de la base de données
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("dateDebut : " + dateFormat.format(timesheet.getTimesheetPK().getDateDebut()));


    }

    @Override
    public List<Mission> findAllMissionByEmployeJPQL(int employeId) {
        return timesheetRepository.findAllMissionByEmployeJPQL(employeId);

    }

    @Override
    public List<Employe> getAllEmployeByMission(int missionId) {
        return timesheetRepository.getAllEmployeByMission(missionId);
    }
}
