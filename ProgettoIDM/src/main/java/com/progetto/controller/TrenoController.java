package com.progetto.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.progetto.eccezioni.TrenoUniversalException;
import com.progetto.model.Utente;
import com.progetto.service.PostoService;
import com.progetto.service.PrenotazionePostoService;
import com.progetto.service.TrenoService;
import com.progetto.service.UtenteService;

@Controller
@RequestMapping
public class TrenoController {

	@Autowired
	TrenoService trenoservice;

	@Autowired
	PostoService postoservice;

	@Autowired
	PrenotazionePostoService prenotazioneservice;

	@Autowired
	UtenteService utenteservice;

	@Autowired
	HttpSession session;
	
	@Autowired
	Utente utente;

	/////////////////

	@GetMapping("addTreni")
	public String addTrenoAlf() {
		return "AddTreni2";
	}

	@GetMapping("/")
	public String home() {
		return "homepage";
	}

	@PostMapping("/AddTreni")
	public String insertTreni(@RequestParam("marca") String marca,
			@RequestParam("ComposizioneTreno") String composizioneTreno) throws TrenoUniversalException {

		if (marca.equals("TN")) {
			trenoservice.addTrenoTN(composizioneTreno);
		} else if (marca.equals("FR")) {
			trenoservice.addTrenoFR(composizioneTreno);
		} else {
			System.out.println("no");
		}

		System.out.println("Valore selezionato della marca: " + marca);
		System.out.println("Valore inserito in ComposizioneTreno: " + composizioneTreno);

		return "AddTreni2";
	}

	//////////////

//	@GetMapping("addTreno")
//	public String addTreno() {
//		return "AddTreno";
//	}
//	
//	
//	
//	@PostMapping("/insertTreno")
//	public String insertTreno(@ModelAttribute("stringa") String string) throws TrenoUniversalException {
//		
//		trenoservice.addTrenoTN(string);
////		return "redirect:/trenoReport";
//		return "redirect:/treni";
//	}

	// Carica tutti i treni
	@GetMapping("/treni")
	public String getAllTreni(Model m) {
		m.addAttribute("treni", trenoservice.getAllTreno());
		System.out.println("lista treni" + trenoservice.getAllTreno());

		return "Treni2";
	}

	@GetMapping("myTrain")
	public String myTrain(Model m) {
		utente = (Utente) session.getAttribute("utenteLoggato");
		m.addAttribute("treniPerUtente", trenoservice.getAllTrenoByUtenteId(utente.getId()));
		return "treniPerUtenteView";
	}
	
//	@GetMapping("/prenotaPosto/{id}")
//	public String prenotaPosto(@PathVariable(value="id") Long id, Model m) {
//		m.addAttribute("vagoni", trenoservice.getAllVagoniPasseggeriByTrenoId(id));
//		return "ScegliVagone";
//		
//	}
//	
//	@GetMapping("prenotaPosto/postiview/{id}")
//	public String postiview(@PathVariable(value="id") Long id, Model m) {
//		m.addAttribute("posti", trenoservice.getAllPostiByVagoneId(id));
//		return "postiview";
//	}
//	
//	
//	@PostMapping("prenotaPosto/postiview/ConfermaPrenotazione")
//	public String confermaPrenotazione(@ModelAttribute("postiSelezionati") String posti) {
//		
//		// crea un array di stringhe nel quale va a inserire tutte le sotto stringhe della 
//		// stringa originale
//		String[] numberStrings = posti.split(",");
//		
//		PrenotazionePosto prenotazione = new PrenotazionePosto();
//		prenotazioneservice.addPrenotazione(prenotazione, numberStrings);
//		
//		utenteservice.updatePrenotazioniUtente(prenotazione, prenotazione.getPrezzo());
//
//        for (int i = 0; i < numberStrings.length; i++) {
//            	postoservice.OccupaPostoById(Long.parseLong(numberStrings[i]));    
//        }
//		
//		System.out.println(posti);
//		return "redirect:/";
//	}

//	@GetMapping("ConfermaPrenotazione")
//	public String confermaPrenotazione() {
//		return "ConfermaPrenotazione";
//	}

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
