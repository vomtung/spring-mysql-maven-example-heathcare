package com.example.mysql.heathycare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.mysql.heathycare.entity.Question;
import com.example.mysql.heathycare.service.QuestionService;

/**
 * 
 * @author vominhtung
 *
 */
@Controller
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(ModelMap mm){
		mm.put("questions", questionService.findAll());
		return "question/list";
	}
	
	@RequestMapping(value="/add" ,method = RequestMethod.GET)
	public String addForm(ModelMap mm){
		Question question = new Question();
		mm.addAttribute("question", question);
		return "question/add";
	}
	
	@RequestMapping(value="/add" ,method = RequestMethod.POST)
	public String add(@ModelAttribute(value="question")Question question){
		questionService.persist(question);
		return "redirect:/question";
	}
	
	@RequestMapping(value="/edit/{id}" ,method = RequestMethod.GET)
	public String editForm(@PathVariable(value = "id")Long id, ModelMap mm){
		Question question = questionService.findById(id);
		mm.put("question", question);
		return "question/edit";
	}
	
	@RequestMapping(value="/edit" ,method = RequestMethod.POST)
	public String edit(@ModelAttribute(value="question")Question question){
		questionService.update(question);
		return "redirect:/question";
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String deleteQuestion(@PathVariable(value = "id")Long id, ModelMap mm){
		Question question = questionService.findById(id);
		questionService.delete(question);
		return "redirect:/question";
	}
}
