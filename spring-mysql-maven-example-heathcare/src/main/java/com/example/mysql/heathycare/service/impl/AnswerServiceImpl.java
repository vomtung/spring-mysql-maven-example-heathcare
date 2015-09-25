package com.example.mysql.heathycare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mysql.heathycare.dao.AnswerDao;
import com.example.mysql.heathycare.entity.Answer;
import com.example.mysql.heathycare.service.AnswerService;
/**
 * 
 * @author vominhtung
 *
 */
@Service("answerService")
public class AnswerServiceImpl implements AnswerService{

	@Autowired
	private AnswerDao answerDao;
	
	@Override
	public List<Answer> findByPatientId(Long patientId) {
		return answerDao.findByPatientId(patientId);
	}

	@Override
	public List<Answer> findAll() {
		return answerDao.findAll();
	}

	@Override
	public Answer findById(Long id) {
		return answerDao.findById(id);
	}

	@Override
	public void update(Answer answer) {
		answerDao.update(answer);
	}
	
}
