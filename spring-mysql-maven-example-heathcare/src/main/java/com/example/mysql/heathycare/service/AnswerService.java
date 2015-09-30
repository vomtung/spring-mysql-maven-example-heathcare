package com.example.mysql.heathycare.service;

import java.util.Set;

import com.example.mysql.heathycare.entity.Answer;
/**
 * 
 * @author vominhtung
 *
 */
public interface AnswerService {
	
	Answer findById(Long id);
	
	Set<Answer> findAll();

	Set<Answer> findByPatientId(Long patientId);
	
	void update(Answer answer);
}
