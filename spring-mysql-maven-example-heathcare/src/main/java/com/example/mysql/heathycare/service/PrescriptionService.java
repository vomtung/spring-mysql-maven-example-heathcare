package com.example.mysql.heathycare.service;

import java.util.Set;

import com.example.mysql.heathycare.entity.Prescription;

/**
 * 
 * @author vominhtung
 *
 */
public interface PrescriptionService {

	Set<Prescription>findAll();
	
	void persist(Prescription prescription);
}
