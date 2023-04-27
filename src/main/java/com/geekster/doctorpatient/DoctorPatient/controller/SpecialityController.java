package com.geekster.doctorpatient.DoctorPatient.controller;

import com.geekster.doctorpatient.DoctorPatient.dto.SpecialityDto;
import com.geekster.doctorpatient.DoctorPatient.model.Speciality;
import com.geekster.doctorpatient.DoctorPatient.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/speciality")
public class SpecialityController {
    @Autowired
    private SpecialityService service;
    @PostMapping("/addSpeciality")
    public Speciality addSpeciality(@RequestBody SpecialityDto specialityType){
        Speciality speciality = service.addSpeciality(specialityType);
//        speciality.setDoctors_list(new ArrayList<>());
        return speciality;
    }

    @GetMapping("/getAllSpecialities")
    public List<Speciality> getAllSpeciality(){
        return service.getAllSpecialities();
    }
}