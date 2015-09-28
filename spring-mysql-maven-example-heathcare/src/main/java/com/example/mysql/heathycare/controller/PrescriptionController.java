package com.example.mysql.heathycare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.mysql.heathycare.entity.Doctor;
import com.example.mysql.heathycare.entity.Patient;
import com.example.mysql.heathycare.entity.Prescription;
import com.example.mysql.heathycare.service.DoctorService;
import com.example.mysql.heathycare.service.PatientService;
import com.example.mysql.heathycare.service.PrescriptionService;

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

	@RequestMapping(method = RequestMethod.GET)
	public String list(ModelMap mm){
		List<Prescription>prescriptions = prescriptionService.findALL();
		mm.addAttribute("prescriptions", prescriptions);
		return "prescription/list";
	}
	
	@RequestMapping(value ="/add", method = RequestMethod.GET)
	public String addPrescriptionForm(ModelMap mm){
		List<Patient>patients = patientService.findAll();
		List<Doctor>doctors = doctorService.findAll();
		Prescription prescription = new Prescription();
		mm.addAttribute("prescription", prescription);
		mm.addAttribute("patientList", patients);
		mm.addAttribute("doctorList", doctors);
		return "prescription/add";
	}
	
	@RequestMapping(value ="/add", method = RequestMethod.POST)
	public String addPrescription(ModelMap mm){
		List<Patient>patients = patientService.findAll();
		List<Doctor>doctors = doctorService.findAll();
		Prescription prescription = new Prescription();
		mm.addAttribute("prescription", prescription);
		mm.addAttribute("patientList", patients);
		mm.addAttribute("doctorList", doctors);
		return "prescription/add";
	}
	
}
