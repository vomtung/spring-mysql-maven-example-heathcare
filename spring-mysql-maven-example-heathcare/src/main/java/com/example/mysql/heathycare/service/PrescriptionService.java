package com.example.mysql.heathycare.service;

import java.util.List;

import com.example.mysql.heathycare.entity.Prescription;

/**
 * 
 * @author vominhtung
 *
 */
public interface PrescriptionService {

	List<Prescription>findALL();
}
