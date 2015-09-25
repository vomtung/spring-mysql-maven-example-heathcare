package com.example.mysql.heathycare.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.mysql.heathycare.entity.Answer;
import com.example.mysql.heathycare.entity.Patient;
import com.example.mysql.heathycare.entity.Question;
/**
 * 
 * @author vominhtung
 *
 */
@Repository("answerDao")
@Transactional
public class AnswerDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Answer findById(Long id){
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Answer a WHERE a.id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		Answer answer = (Answer)(query.list().size()!=1?null:query.list().get(0));
		return answer;
	}
	
	public List<Answer> findByPatientId(Long patientId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM Answer a WHERE a.patient.id = :patientId";
		Query query = session.createQuery(hql);
		query.setParameter("patientId", patientId);
		List results = (List<Patient>)query.list();
		return results;
	}
	
	public List<Answer> findAll() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Answer.class);
		return (List<Answer>) criteria.list();
	}
	
	public void update(Answer answer) {
		sessionFactory.getCurrentSession().update(answer);
	}
}
