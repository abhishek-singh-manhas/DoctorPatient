package com.geekster.doctorpatient.DoctorPatient.service;

import com.geekster.doctorpatient.DoctorPatient.helper.Status;
import com.geekster.doctorpatient.DoctorPatient.repository.IStatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusService {

    @Autowired
    private IStatusRepo statusRepo;

    public Status createStatus(Status status) {
        Status save = statusRepo.save(status);
        return save;
    }
}