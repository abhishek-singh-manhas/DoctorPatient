package com.geekster.doctorpatient.DoctorPatient.service;

import com.geekster.doctorpatient.DoctorPatient.dto.DocDto;
import com.geekster.doctorpatient.DoctorPatient.exceptionHandler.NotValid;
import com.geekster.doctorpatient.DoctorPatient.helper.Validations;
import com.geekster.doctorpatient.DoctorPatient.model.Doctor;
import com.geekster.doctorpatient.DoctorPatient.model.Speciality;
import com.geekster.doctorpatient.DoctorPatient.repository.IDoctorRepo;
import com.geekster.doctorpatient.DoctorPatient.repository.ISpecialityRepo;
import com.geekster.doctorpatient.DoctorPatient.repository.IStatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DoctorService {
    @Autowired
    private IDoctorRepo IDoctorRepo;
    @Autowired
    private ISpecialityRepo specialityRepo;
    @Autowired
    private IStatusRepo statusRepo;
    public Doctor addDoctor(DocDto dto) {
        Doctor d = new Doctor();
        d.setFirst_name(dto.getFirst_name());
        d.setLast_name(dto.getLast_name());
        d.setCity(dto.getCity().toLowerCase());
        d.setEmail(dto.getEmail());
        d.setAddress(dto.getAddress());
        List<Speciality> bySpeciality = specialityRepo.findBySpeciality(dto.getSpeciality());
        if(bySpeciality.isEmpty()){
            throw new NullPointerException("No Speciality Found With -> "+dto.getSpeciality());
        }
        d.setSpeciality(bySpeciality.get(0));
        if(!Validations.isValidMobileNo(dto.getPhone_number())){
            throw new NullPointerException("Please provide valid phone number");
        }
        d.setPhone_number(dto.getPhone_number());
        d.setStatus(statusRepo.findById(1).get());
        Doctor save = IDoctorRepo.save(d);
        return save;
    }


    public void deleteById(Long id) throws NotValid {
        if(IDoctorRepo.findById(id).isPresent()) {
            IDoctorRepo.deleteByIdChangeStatus(2, id);
        }else{
            throw new NotValid("No doctor found with id -> "+id+" please consider providing valid id");
        }
    }

    public List<Doctor> getAll() {
        return IDoctorRepo.findAll();
    }

    public Doctor updateDoctor(DocDto dto, Long doc_id) throws NotValid {
        if(!IDoctorRepo.findById(doc_id).isPresent()){
            throw new NotValid("No doctor found with id -> "+doc_id+" please consider providing valid id");
        }
        Doctor d = IDoctorRepo.findById(doc_id).get();
        d.setFirst_name(dto.getFirst_name());
        d.setLast_name(dto.getLast_name());
        d.setCity(dto.getCity().toLowerCase());
        d.setEmail(dto.getEmail());
        d.setAddress(dto.getAddress());
        List<Speciality> bySpeciality = specialityRepo.findBySpeciality(dto.getSpeciality());
        if(bySpeciality.isEmpty()){
            throw new NullPointerException("No Speciality Found With -> "+dto.getSpeciality());
        }
        d.setSpeciality(bySpeciality.get(0));
        if(!Validations.isValidMobileNo(dto.getPhone_number())){
            throw new NullPointerException("Please provide valid phone number");
        }
        d.setPhone_number(dto.getPhone_number());
        d.setStatus(statusRepo.findById(1).get());
        Doctor save = IDoctorRepo.save(d);
        return save;
    }
}