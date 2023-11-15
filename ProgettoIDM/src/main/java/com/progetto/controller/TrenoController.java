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
		return "PagineJspCanoniche/creaTreno/creaTreno";
	}

	@GetMapping("/home")
	public String home() {
		return "PagineJspCanoniche/homePage/homePage";
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

		return "PagineJspCanoniche/creaTreno/creaTreno";
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

		return "PagineJspCanoniche/viewTreni/viewTreni";
	}

	@GetMapping("myTrain")
	public String myTrain(Model m) {
		utente = (Utente) session.getAttribute("utenteLoggato");
		m.addAttribute("treniPerUtente", trenoservice.getAllTrenoByUtenteId(utente.getId()));
		return "treniPerUtenteView";
	}
}
