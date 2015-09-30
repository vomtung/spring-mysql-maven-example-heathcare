package com.example.mysql.heathycare.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.mysql.heathycare.entity.Question;
/**
 * 
 * @author vominhtung
 *
 */
@Repository("questionDao")
@Transactional
public class QuestionDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Set<Question> findAll() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Question.class);
		return new HashSet<Question>(criteria.list());
	}
	
	public void persist(Question question) {
		sessionFactory.getCurrentSession().persist(question);
	}
	
	public void delete(Question question) {
		sessionFactory.getCurrentSession().delete(question);
	}
	
	public Question findById(Long id){
		return (Question)sessionFactory.getCurrentSession().get(Question.class, id);
	}
	
	public void update(Question question){
		sessionFactory.getCurrentSession().update(question);
	}
}
