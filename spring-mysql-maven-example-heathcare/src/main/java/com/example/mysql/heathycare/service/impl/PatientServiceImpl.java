package com.example.msql.heathycare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.msql.heathycare.dao.PatientDao;
import com.example.msql.heathycare.entity.Patient;
import com.example.msql.heathycare.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{

	@Autowired
	private PatientDao patientDao;
	
	@Override
	@Transactional
	public List<Patient> findAll() {
		return patientDao.findAll();
	}

	@Override
	@Transactional
	public void create(Patient patient) {
		patientDao.create(patient);;
	}
}
