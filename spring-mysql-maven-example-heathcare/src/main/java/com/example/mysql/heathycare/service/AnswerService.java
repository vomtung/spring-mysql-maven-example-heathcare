package com.example.mysql.heathycare.service;

import java.util.List;

import com.example.mysql.heathycare.entity.Answer;
/**
 * 
 * @author vominhtung
 *
 */
public interface AnswerService {
	
	Answer findById(Long id);
	
	List<Answer> findAll();

	List<Answer> findByPatientId(Long patientId);
	
	void update(Answer answer);
}
