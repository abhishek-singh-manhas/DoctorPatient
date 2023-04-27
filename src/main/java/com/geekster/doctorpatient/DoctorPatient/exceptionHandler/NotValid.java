package com.geekster.doctorpatient.DoctorPatient.exceptionHandler;


public class NotValid extends Throwable{
    public NotValid(String message){
        super(message);
    }
}