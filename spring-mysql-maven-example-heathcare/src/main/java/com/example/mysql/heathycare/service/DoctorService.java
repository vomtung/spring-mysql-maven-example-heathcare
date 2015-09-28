package com.example.mysql.heathycare.service;

import java.util.List;

import com.example.mysql.heathycare.entity.Doctor;
/**
 * 
 * @author vominhtung
 *
 */
public interface DoctorService {
	
	List<Doctor>findAll();
	
	
	void persist(Doctor doctor);
	
}
