package com.example.mysql.heathycare.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.mysql.heathycare.entity.Doctor;
import com.example.mysql.heathycare.service.DoctorService;

/**
 * 
 * @author vominhtung
 *
 */
@Controller
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String index(ModelMap mm){
		Set<Doctor>doctors = doctorService.findAll();
		mm.addAttribute("doctors", doctors);
		return "doctor/list";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addDoctorForm(ModelMap mm){
		Doctor doctor = new Doctor();
		mm.addAttribute("doctor", doctor);
		return "doctor/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addDoctor(@ModelAttribute(value="doctor")Doctor doctor){
		doctorService.persist(doctor);
		return "redirect:/doctor";
	}
}
