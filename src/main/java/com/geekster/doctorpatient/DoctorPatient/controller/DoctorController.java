package com.geekster.doctorpatient.DoctorPatient.controller;

import com.geekster.doctorpatient.DoctorPatient.dto.DocDto;
import com.geekster.doctorpatient.DoctorPatient.exceptionHandler.NotValid;
import com.geekster.doctorpatient.DoctorPatient.model.Doctor;
import com.geekster.doctorpatient.DoctorPatient.service.DoctorService;
import jakarta.validation.Valid;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping("/addDoctor")
    public Doctor addDoctor(@Valid @RequestBody DocDto dto) {
        return doctorService.addDoctor(dto);
    }

    @DeleteMapping("/deleteDoctorById")
    public ResponseEntity<String> deleteById(@RequestParam Long id) throws NotValid {
        doctorService.deleteById(id);
        return new ResponseEntity<>("Doctor deleted having id -> "+id, HttpStatus.OK);
    }

    @GetMapping("/getAllDoctors")
    public ResponseEntity<List<Doctor>> getAll(){
        return new ResponseEntity<>(doctorService.getAll(), HttpStatus.OK);
    }

    @PutMapping("/updateDoctor")
    public Doctor updateDoctor(@RequestBody DocDto dto,@NonNull @RequestParam Long doc_id) throws NotValid {
        return doctorService.updateDoctor(dto, doc_id);
    }

}