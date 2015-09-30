package com.example.mysql.heathycare.controller;

import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.mysql.heathycare.entity.Answer;
import com.example.mysql.heathycare.entity.Doctor;
import com.example.mysql.heathycare.entity.Patient;
import com.example.mysql.heathycare.entity.Prescription;
import com.example.mysql.heathycare.service.AnswerService;
import com.example.mysql.heathycare.service.DoctorService;
import com.example.mysql.heathycare.service.PatientService;
import com.example.mysql.heathycare.service.PrescriptionService;

import flexjson.JSONSerializer;

/**
 * 
 * @author vominhtung
 *
 */
@Controller
@RequestMapping(value="/prescription")
public class PrescriptionController {
	
	@Autowired
	private PrescriptionService prescriptionService;
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private AnswerService answerService;

	@RequestMapping(method = RequestMethod.GET)
	public String list(ModelMap mm){
		Set<Prescription>prescriptions = prescriptionService.findAll();
		mm.addAttribute("prescriptions", prescriptions);
		return "prescription/list";
	}
	
	@RequestMapping(value ="/add", method = RequestMethod.GET)
	public String addPrescriptionForm(ModelMap mm){
		Set<Patient>patients = patientService.findAll();
		Set<Doctor>doctors = doctorService.findAll();
		Prescription prescription = new Prescription();
		mm.addAttribute("prescription", prescription);
		mm.addAttribute("patientList", patients);
		mm.addAttribute("doctorList", doctors);
		return "prescription/add";
	}
	
	@RequestMapping(value ="/add", method = RequestMethod.POST)
	public String addPrescription(@ModelAttribute(value="prescription")Prescription prescription, ModelMap mm, HttpServletRequest request){
		prescriptionService.persist(prescription);
		return "redirect:/prescription";
	}
	
	@RequestMapping(value ="/list_json" ,method = RequestMethod.GET)
	@ResponseBody
	public String listJSON(){
		Set<Prescription>prescriptions = prescriptionService.findAll();
		JSONSerializer serializer = new JSONSerializer();
		for (Iterator iterator = prescriptions.iterator(); iterator.hasNext();) {
			Prescription prescription = (Prescription) iterator.next();
			Patient patient = prescription.getPatient();
			Set<Answer>answers = answerService.findByPatientId(patient.getId());
			patient.setAnswer(answers);
		}
		serializer.exclude("*.class");
		serializer.include("patient");
		return serializer.serialize(prescriptions);
	}
	
}
