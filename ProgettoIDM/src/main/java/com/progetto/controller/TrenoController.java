package com.progetto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.progetto.service.TrenoService;

@Controller
@RequestMapping
public class TrenoController {

	@Autowired
	TrenoService trenoservice;
	
	@GetMapping("addTreno")
	public String addTreno() {
		return "AddTreno";
	}
	
	@PostMapping("/insertTreno")
	public String insertTreno(@ModelAttribute("stringa") String string) {
		
		trenoservice.addTrenoTN(string);
//		return "redirect:/trenoReport";
		return "redirect:/treni";
	}
	
	
	//Carica tutti i treni
	@GetMapping("/treni")
	public String getAllTreni(Model m) {
		m.addAttribute("treni", trenoservice.getAllTreno());
		System.out.println("lista treni" + trenoservice.getAllTreno());
		
		return "treni";
	}
	
	
	@GetMapping("/prenotaPosto/{id}")
	public String prenotaPosto(@PathVariable(value="id") Long id, Model m) {
		m.addAttribute("vagoni", trenoservice.getAllVagoniByTrenoId(id));
		return "prenotaPosto";
		
	}
//	@GetMapping("/treniView")
//	public String treniView() {
//		return "treniView";
//	}
	
//	@GetMapping("addTreno")
//	public String addTreno() {
//		return "AddTreno";
//	}
//	
//	@PostMapping("/insertTreno")
//	public String insertTreno(@ModelAttribute("insertTreno") TrenoDTO treno) {
//		trenoservice.addTreno(treno);
////		return "redirect:/trenoReport";
//		return "AddTreno";
//	}
	
//	@GetMapping("/employeeReport")
//	public String loadEmployee(Model m) {
//		m.addAttribute("employee", employeeService.getAllEmp());
//		m.addAttribute("title", "Employee Report");
//		
//		return "EmployeeReport";
//	}
//	
//	@GetMapping("/editEmployee/{id}")
//	public String lodeEditForm(@PathVariable(value="id") Long id, Model m)
//	{
//		Employee emp=employeeService.getEmpById(id);
//		
//		System.out.println(emp);
//		m.addAttribute("employee", emp);
//		m.addAttribute("title", "Edit Employee");
//		
//		return "EditEmployee";
//		
//	}
//	
//	
//	
//	@PostMapping("/editEmployee/updateEmployee")
//	public String updateEmp(@ModelAttribute("updateEmployee") Employee emp)
//	{
//		employeeService.updateEmp(emp);
//		
//		return "redirect:/employeeReport";
//		
//	}
//	
//	@GetMapping("/deleteEmployee/{id}")
//	public String deleteEmployee(@PathVariable Long id) {
//		employeeService.deleteEmp(id);
//		return "redirect:/employeeReport";
//	}
}
