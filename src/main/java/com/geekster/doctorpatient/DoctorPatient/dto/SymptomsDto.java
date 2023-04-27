package com.geekster.doctorpatient.DoctorPatient.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SymptomsDto {
    private String symptom;
    private String speciality;
}