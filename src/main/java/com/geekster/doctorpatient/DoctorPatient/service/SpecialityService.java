package com.geekster.doctorpatient.DoctorPatient.service;

import com.geekster.doctorpatient.DoctorPatient.dto.SpecialityDto;
import com.geekster.doctorpatient.DoctorPatient.model.Speciality;
import com.geekster.doctorpatient.DoctorPatient.repository.ISpecialityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialityService {
    @Autowired
    private ISpecialityRepo specialityRepo;

    public Speciality addSpeciality(SpecialityDto specialityType) {
        Speciality speciality = new Speciality();
        speciality.setSpeciality_type(specialityType.getSpeciality_type());
        Speciality save = specialityRepo.save(speciality);
        return save;
    }


    public List<Speciality> getAllSpecialities() {
        return specialityRepo.findAll();
    }
}
