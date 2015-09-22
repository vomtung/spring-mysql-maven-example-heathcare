package com.example.msql.heathycare.service;

import java.util.List;

import com.example.msql.heathycare.entity.Patient;

public interface PatientService {
	
	public List<Patient> findAll();
	
	public void create(Patient patient);

}
