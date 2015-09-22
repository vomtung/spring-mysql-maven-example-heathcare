package com.example.msql.heathycare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.msql.heathycare.entity.Patient;
import com.example.msql.heathycare.service.PatientService;

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

	@RequestMapping(value ="/list_json" ,method = RequestMethod.GET)
	@ResponseBody
	public String listJSON(){
		List<Patient>patients = patientService.findAll();
		JSONSerializer serializer = new JSONSerializer();
		serializer.exclude("*.class");
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
		patientService.create(patient);
		return "redirect:/patient";
	}
}
