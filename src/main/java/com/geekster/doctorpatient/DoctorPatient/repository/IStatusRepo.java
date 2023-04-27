package com.geekster.doctorpatient.DoctorPatient.repository;

import com.geekster.doctorpatient.DoctorPatient.helper.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStatusRepo extends JpaRepository<Status,Integer> {
}