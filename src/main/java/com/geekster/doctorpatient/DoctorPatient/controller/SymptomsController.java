package com.geekster.doctorpatient.DoctorPatient.controller;

import com.geekster.doctorpatient.DoctorPatient.dto.SymptomsDto;
import com.geekster.doctorpatient.DoctorPatient.model.Symptoms;
import com.geekster.doctorpatient.DoctorPatient.service.SymptomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/symptoms")
public class SymptomsController {
    @Autowired
    private SymptomsService service;
    @PostMapping("/addSymptoms")
    public Symptoms addSymptoms(@RequestBody SymptomsDto sysmptomsDto){
        Symptoms s = service.addSymptom(sysmptomsDto);
        return s;
    }

    @GetMapping("/getAllSymptomsAndSpeciality")
    public List<Symptoms> getAllSymptoms(){
        return service.getAllSymptoms();
    }
}