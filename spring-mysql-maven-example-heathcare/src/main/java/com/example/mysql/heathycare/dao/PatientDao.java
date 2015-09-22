package com.example.msql.heathycare.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.msql.heathycare.entity.Patient;

/**
 * 
 * @author vominhtung
 *
 */
@Repository("patientDao")
@Transactional
public class PatientDao {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Patient> findAll() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Patient.class);
		return (List<Patient>) criteria.list();
	}

	public void create(Patient patient) {
		sessionFactory.getCurrentSession().persist(patient);
	}
}
