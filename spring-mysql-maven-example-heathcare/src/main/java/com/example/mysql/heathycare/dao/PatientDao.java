package com.example.mysql.heathycare.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.mysql.heathycare.entity.Patient;

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
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Patient e";
		Query query = session.createQuery(hql);
		List results = (List<Patient>)query.list();
		return results;
	}

	public void persist(Patient patient) {
		sessionFactory.getCurrentSession().persist(patient);
	}
}
