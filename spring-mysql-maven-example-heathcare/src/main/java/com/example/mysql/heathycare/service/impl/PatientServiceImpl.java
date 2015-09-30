package com.example.mysql.heathycare.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mysql.heathycare.dao.PatientDao;
import com.example.mysql.heathycare.entity.Patient;
import com.example.mysql.heathycare.service.PatientService;



@Service
public class PatientServiceImpl implements PatientService{

	@Autowired
	private PatientDao patientDao;
	
	@Override
	@Transactional
	public Set<Patient> findAll() {
		return patientDao.findAll();
	}

	@Override
	@Transactional
	public void persist(Patient patient) {
		patientDao.persist(patient);;
	}

	@Override
	@Transactional
	public void delete(Patient patient) {
		patientDao.delete(patient);
	}

	@Override
	@Transactional
	public Patient findById(Long id) {
		return patientDao.findById(id);
	}

}
