package com.example.mysql.heathycare.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
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

	public Set<Prescription> findAll() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Prescription p";
		Query query = session.createQuery(hql);
		Set results = new HashSet<Prescription>(query.list());
		return results;
	}

	public void persist(Prescription prescription){
		sessionFactory.getCurrentSession().persist(prescription);
	}
	
}
