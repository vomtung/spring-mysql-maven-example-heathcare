package com.example.mysql.heathycare.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.mysql.heathycare.entity.Doctor;

/**
 * 
 * @author vominhtung
 *
 */
@Repository
@Transactional
public class DoctorDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Set<Doctor>findAll(){
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Doctor d";
		Query query = session.createQuery(hql);
		Set results = new HashSet<Doctor>(query.list());
		return results;
	}
	
	public void persist(Doctor doctor) {
		sessionFactory.getCurrentSession().persist(doctor);
	}
}
