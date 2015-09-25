package com.example.mysql.heathycare.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.mysql.heathycare.entity.Answer;
import com.example.mysql.heathycare.service.AnswerService;

/**
 * 
 * @author vominhtung
 *
 */
@Controller
@RequestMapping("/answer")
public class AnswerController {

	@Autowired
	AnswerService answerService;
	
//	@RequestMapping(method = RequestMethod.GET)
//	public String list(ModelMap mm){
//		mm.put("questions", answerService.findAll());
//		return "question/list";
//	}
	
	@RequestMapping(value ="/update/{id}" ,method =RequestMethod.GET)
	public String updateForm(@PathVariable Long id ,ModelMap mm){
		Answer answer = answerService.findById(id);
		mm.addAttribute("answer", answer);
		return "answer/update";
	}
	
	@RequestMapping(value ="/update" ,method =RequestMethod.POST)
	@Transactional
	public String update(@ModelAttribute(value="answer") Answer answer, HttpServletRequest request, ModelMap mm){
		Answer originAnswer = answerService.findById(answer.getId());
		originAnswer.setAnswer(answer.getAnswer());
		answerService.update(originAnswer);
		return "redirect:/patient/answer/"+originAnswer.getPatient().getId();
	}
}
