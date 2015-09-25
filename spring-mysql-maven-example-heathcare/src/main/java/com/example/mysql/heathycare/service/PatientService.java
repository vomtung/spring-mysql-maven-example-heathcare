package com.example.mysql.heathycare.service;

import java.util.List;

import com.example.mysql.heathycare.entity.Patient;


public interface PatientService {
	
	public List<Patient> findAll();
	
	public void persist(Patient patient);

}
