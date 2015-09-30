package com.example.mysql.heathycare.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mysql.heathycare.dao.DoctorDao;
import com.example.mysql.heathycare.entity.Doctor;
import com.example.mysql.heathycare.service.DoctorService;
/**
 * 
 * @author vominhtung
 *
 */
@Service(value="doctorService")
public class DoctorServiceImpl implements DoctorService{

	@Autowired
	private DoctorDao doctorDao;
	
	@Override
	public Set<Doctor> findAll() {
		return doctorDao.findAll();
	}
	
	@Override
	public void persist(Doctor doctor){
		doctorDao.persist(doctor);
	}

}
