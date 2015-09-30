package com.example.mysql.heathycare.service;

import java.util.Set;

import com.example.mysql.heathycare.entity.Doctor;
/**
 * 
 * @author vominhtung
 *
 */
public interface DoctorService {
	
	Set<Doctor>findAll();
	
	void persist(Doctor doctor);
	
}
