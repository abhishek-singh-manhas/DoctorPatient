package com.geekster.doctorpatient.DoctorPatient.service;

import com.geekster.doctorpatient.DoctorPatient.dto.SymptomsDto;
import com.geekster.doctorpatient.DoctorPatient.model.Speciality;
import com.geekster.doctorpatient.DoctorPatient.model.Symptoms;
import com.geekster.doctorpatient.DoctorPatient.repository.ISpecialityRepo;
import com.geekster.doctorpatient.DoctorPatient.repository.ISymptomsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SymptomsService {
    @Autowired
    private ISymptomsRepo symptomsRepo;
    @Autowired
    private ISpecialityRepo specialityRepo;
    public Symptoms addSymptom(SymptomsDto sysmptomsDto) {
        List<Speciality> bySpeciality = specialityRepo.findBySpeciality(sysmptomsDto.getSpeciality());
        Speciality s = bySpeciality.get(0);
        Symptoms symptoms = new Symptoms();
        symptoms.setSymptom(sysmptomsDto.getSymptom().toLowerCase());
        symptoms.setSpeciality(s);
        Symptoms save = symptomsRepo.save(symptoms);
        return save;
    }

    public List<Symptoms> getAllSymptoms() {
        return symptomsRepo.findAll();
    }
}