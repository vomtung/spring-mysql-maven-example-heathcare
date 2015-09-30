package com.example.mysql.heathycare.service;

import java.util.Set;

import com.example.mysql.heathycare.entity.Question;

/**
 * 
 * @author vominhtung
 *
 */
public interface QuestionService {

	Set<Question>findAll();
	
	void persist(Question question);
	
	void delete(Question question);
	
	Question findById(Long id);

	void update(Question question);
}
