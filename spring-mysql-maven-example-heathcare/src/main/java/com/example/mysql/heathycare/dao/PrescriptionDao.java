package com.example.mysql.heathycare.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.mysql.heathycare.entity.Prescription;

/**
 * 
 * @author vominhtung
 *
 */
@Repository("prescriptionDao")
@Transactional
public class PrescriptionDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	public List<Prescription> findAll() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Prescription.class);
		return (List<Prescription>) criteria.list();
	}

	
}
