package com.corso.spring.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // Annotation figlia di Component
public class TrenoController {

	
	@GetMapping("/home")
	public String home() {
		System.out.println("sei nel controller home()"); 
		return "home";
	}
	
	@GetMapping("crea")
	public String insert(@RequestParam String sigla, Model model ) {
		System.out.println("creo un treno con sigla " + sigla); 
		String message  =""; 
		if (sigla.indexOf("H")!=0) {
			message= "Non c'� la locomotiva in testa!"; 
			
		} else {
			
			message="tutto a posto!"; 
			
			
		}
		model.addAttribute("message",message ); 
		
		
		return "insertDone";
	}
	
}
