package com.example.mysql.heathycare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mysql.heathycare.dao.PrescriptionDao;
import com.example.mysql.heathycare.entity.Prescription;
import com.example.mysql.heathycare.service.PrescriptionService;
/**
 * 
 * @author vominhtung
 *
 */
@Service(value="prescriptionService")
public class PrescriptionServiceImpl implements PrescriptionService{

	@Autowired
	private PrescriptionDao prescriptionDao;
	
	@Override
	public List<Prescription> findALL() {
		return prescriptionDao.findAll();
	}

}
