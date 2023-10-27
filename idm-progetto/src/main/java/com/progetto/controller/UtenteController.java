package com.progetto.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.progetto.model.Utente;
import com.progetto.service.UtenteService;

@Controller
@RequestMapping
public class UtenteController {

	@Autowired 
	UtenteService utenteservice;
	
	@GetMapping("addUtente")
	public String addUtente() {
		return "AddUtente";
	}
	
	@PostMapping("/insertUtente")
	public String insertUtente(@ModelAttribute("insertUtente") Utente utente) {
		utenteservice.addUtente(utente);
//		return "redirect:/utenteReport";
		return "LoginUtente";
	}
	
	@GetMapping("/loginUtente")
	public String loginUtente() {
		return "LoginUtente";
	}
	
	@PostMapping("/login")
	public String processLogin(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) {
	    // verifico le credenziali dell'utente
	    Utente utente = utenteservice.findUtenteByUsername(username);
	    
	    if (utente != null && utente.getPassword().equals(password)) {
	        // Le credenziali sono corrette, quindi registra l'utente nella sessione
	        session.setAttribute("utenteLoggato", utente);
	        return "UtenteDashboard"; // Reindirizza a una pagina dopo il login
	    } else {
	        // credenziali errate
	    	session.setAttribute("msg", "Invalid data");
	        return "redirect:/loginUtente";
	    }
	}
	






	
//	@PostMapping("/checkUtente")
//	public String checkUtente(@ModelAttribute("checkUtente") Utente utente) {
//		System.out.println("user");
//		
//		return "LoginUtente";
//	}
}
