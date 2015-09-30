package com.example.mysql.heathycare.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mysql.heathycare.dao.QuestionDao;
import com.example.mysql.heathycare.entity.Question;
import com.example.mysql.heathycare.service.QuestionService;
/**
 * 
 * @author vominhtung
 *
 */
@Service(value ="QuestionService")
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	private QuestionDao questionDao;
	
	@Override
	public Set<Question> findAll() {
		return questionDao.findAll();
	}

	@Override
	public void persist(Question question) {
		questionDao.persist(question);
	}

	@Override
	public void delete(Question question) {
		questionDao.delete(question);
	}

	@Override
	public Question findById(Long id) {
		return questionDao.findById(id);
	}

	@Override
	public void update(Question question) {
		questionDao.update(question);
	}

}
