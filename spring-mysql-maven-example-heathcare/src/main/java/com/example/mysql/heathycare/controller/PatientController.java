package com.example.mysql.heathycare.controller;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.mysql.heathycare.entity.Answer;
import com.example.mysql.heathycare.entity.Patient;
import com.example.mysql.heathycare.entity.Question;
import com.example.mysql.heathycare.service.AnswerService;
import com.example.mysql.heathycare.service.PatientService;
import com.example.mysql.heathycare.service.QuestionService;

import flexjson.JSONSerializer;

/**
 * 
 * @author vominhtung
 *
 */
@Controller
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private AnswerService answerService;

	@RequestMapping(value ="/list_json" ,method = RequestMethod.GET)
	@ResponseBody
	public String listJSON(){
		List<Patient>patients = patientService.findAll();
		for (Iterator iterator = patients.iterator(); iterator.hasNext();) {
			Patient patient = (Patient) iterator.next();
			List<Answer>answers = answerService.findByPatientId(patient.getId());
			patient.setAnswer(answers);
		}
		JSONSerializer serializer = new JSONSerializer();
		serializer.exclude("*.class");
		serializer.include("answer");
		return serializer.serialize(patients);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(ModelMap mm){
		List<Patient>patients = patientService.findAll();
		mm.put("patients", patients);
		return "patient/list";
	}
	
	@RequestMapping(value ="/add" ,method = RequestMethod.GET)
	public String addForm(ModelMap mm){
		Patient patient = new Patient();
		mm.put("patient", patient);
		return "patient/add";
	}
	
	@RequestMapping(value ="/add", method = RequestMethod.POST)
	public String add(@ModelAttribute(value = "patient")Patient patient){
		List<Question>questions = questionService.findAll();
		List<Answer>answers = new LinkedList<Answer>();
		for (Iterator iterator = questions.iterator(); iterator.hasNext();) {
			Question question = (Question) iterator.next();
			Answer answer = new Answer();
			answer.setQuestion(question);
			answer.setPatient(patient);
			answers.add(answer);
		}
		patient.setAnswer(answers);
		patientService.persist(patient);
		return "redirect:/patient";
	}
	
	@RequestMapping(value ="/answer/{patientId}" ,method = RequestMethod.GET)
	public String listAnswer(@PathVariable(value="patientId")Long patientId, ModelMap mm){
		List<Answer>answers = answerService.findByPatientId(patientId);
		mm.put("answers", answers);
		return "patient/answer_list";
	}
}
