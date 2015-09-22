package com.example.msql.heathycare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.msql.heathycare.service.PatientService;

/**
 * 
 * @author vominhtung
 *
 */
@Controller
@RequestMapping("/index")
public class IndexController {
	
	@Autowired
	private PatientService patientService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap mm){
		return "index";
	}
	
}
