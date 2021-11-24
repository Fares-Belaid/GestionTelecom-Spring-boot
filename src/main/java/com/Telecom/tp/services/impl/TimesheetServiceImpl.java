package com.Telecom.tp.services.impl;

import com.Telecom.tp.entities.Departement;
import com.Telecom.tp.entities.Employe;
import com.Telecom.tp.entities.Mission;
import com.Telecom.tp.repository.DepartementRepository;
import com.Telecom.tp.repository.MissionRepository;
import com.Telecom.tp.repository.TimesheetRepository;
import com.Telecom.tp.services.TimesheetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            // à rechercher
    }

    @Override
    public void validerTimesheet(int missionId, int employeId, Date dateDebut, Date dateFin, int validateurId) {

    }

    @Override
    public List<Mission> findAllMissionByEmployeJPQL(int employeId) {
        return null;
    }

    @Override
    public List<Employe> getAllEmployeByMission(int missionId) {
        return null;
    }
}
