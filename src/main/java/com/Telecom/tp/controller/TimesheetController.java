package com.Telecom.tp.controller;

import com.Telecom.tp.entities.Mission;
import com.Telecom.tp.services.TimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/timesheet")
public class TimesheetController {

    @Autowired
    TimesheetService timesheetService;

    @PostMapping("/ajouterMission")
    public int ajouterMission(@RequestBody Mission mission){
          return timesheetService.ajouterMission(mission);
    }

    @GetMapping("/findAllMissionByEmploye/{employeId}")
    public List<Mission> findAllMissionByEmploye(@PathVariable("employeId") int employeId){
        return timesheetService.findAllMissionByEmployeJPQL(employeId);
    }

    @PutMapping("/validerTimesheet/{missionId}/{employeId}/{validateurId}")
    public void validerTimesheet(@PathVariable("missionId") int missionId,@PathVariable("employeId") int employeId,@RequestBody Date dateDebut,@RequestBody Date dateFin,@PathVariable("validateurId") int validateurId){
        timesheetService.validerTimesheet(missionId,employeId,dateDebut,dateFin,validateurId);
    }

    //TODO les autres services
}
