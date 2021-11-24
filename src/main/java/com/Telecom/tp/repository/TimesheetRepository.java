package com.Telecom.tp.repository;

import com.Telecom.tp.entities.Employe;
import com.Telecom.tp.entities.Mission;
import com.Telecom.tp.entities.Timesheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface TimesheetRepository extends JpaRepository<Timesheet, Integer> {


    @Query("select t from Timesheet t " +
            "where t.mission =: mission and t.employe =: employe " +
            "and t.timesheetPK.dateDebut >=: dateDebut " +
            "and t.timesheetPK.dateFin<=: dateFin")
    public List<Timesheet> getTimesheetsByMissionAndDate(@Param("employe") Employe employe, @Param("mission")
                                                         Mission mission, @Param("dateDebut")Date dateDebut,
                                                         @Param("dateFin")Date dateFin);

    @Query("select e from Employe e" +
            " join e.timesheets t " +
            " join t.mission m " +
            "where m.id =: missionId")
    public List<Employe> getAllEmployeByMission(@Param("missionId") int missionId);


    @Query("select m from Mission m" +
            " join m.timesheets t" +
            " join t.employe e " +
            "where e.id =: employeId")
    public List<Mission> findAllMissionByEmployeJPQL(@Param("employeId")int employeId);
}
