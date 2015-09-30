package com.example.mysql.heathycare.service;

import java.util.Set;

import com.example.mysql.heathycare.entity.Patient;

/**
 * 
 * @author vominhtung
 *
 */
public interface PatientService {
	
	Patient findById(Long id);
	
	Set<Patient> findAll();
	
	void persist(Patient patient);
	
	void delete(Patient patient);
	
}
