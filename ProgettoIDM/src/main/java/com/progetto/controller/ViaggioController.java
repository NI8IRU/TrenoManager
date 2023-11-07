package com.progetto.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.progetto.model.PrenotazionePosto;
import com.progetto.model.Viaggio;
import com.progetto.service.PostoService;
import com.progetto.service.PrenotazionePostoService;
import com.progetto.service.TrenoService;
import com.progetto.service.UtenteService;
import com.progetto.service.ViaggioService;
import com.progetto.vagoni.PostoASedere;

@Controller
public class ViaggioController {

	
	@Autowired 
	HttpSession session;
	
	@Autowired
	Viaggio viaggio;
	
	@Autowired
	ViaggioService viaggioservice;
	
	@Autowired
	TrenoService trenoservice;
	
	@Autowired 
	PostoService postoservice;
	
	@Autowired
	PrenotazionePostoService prenotazioneservice;
	
	@Autowired
	UtenteService utenteservice;
	
	@Autowired
	PrenotazionePosto prenotazione;
	
	@GetMapping("/createViaggio/{id}")
	public String creteViaggio(@PathVariable(value="id") Long id, Model m) {
		m.addAttribute("treno", id);
		return "createViaggio";
		
	}
	
	@PostMapping("createViaggio/AddViaggio")
	public String insertViaggio(
			@RequestParam("dataPartenza") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataPartenza, 
	        @RequestParam("dataArrivo") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataArrivo,  
			@RequestParam("stazionePartenza") String stazionePartenza, 
			@RequestParam("stazioneDestinazione") String stazioneDestinazione,
			@RequestParam("idTreno") String idTreno) {

		viaggioservice.addViaggio(dataPartenza, dataArrivo, stazionePartenza, stazioneDestinazione, idTreno);
		
		
	    return "redirect:/viaggi";
	}
	
	
	@GetMapping("/viaggi")
	public String getAllViaggi(Model m) {
		m.addAttribute("viaggi", viaggioservice.getAllViaggi());
//		session.removeAttribute("viaggioId");
		
		return "viaggi";
	}
	
	@GetMapping("/prenotaPosto/{id}")
	public String prenotaPosto(@PathVariable(value="id") Long id, Model m) {
//		m.addAttribute("vagoni", trenoservice.getAllVagoniByTrenoId(viaggioservice.findTrenoByViaggio(id).getId()));
//		m.addAttribute("posti", viaggioservice.getAllPostiByViaggioId(id));
		
		m.addAttribute("vagoni", trenoservice.getAllVagoniPasseggeriByTrenoId(viaggioservice.getViaggioById(id).getTreno().getId()));
		session.setAttribute("viaggioId", id);
		return "ScegliVagone";
		
	}
	
	@GetMapping("prenotaPosto/postiview/{id}")
	public String postiview(@PathVariable(value="id") Long id, Model m) {
		List <PrenotazionePosto> listaPrenotazioni = 
				prenotazioneservice.findPrenotazioniByViaggioId((Long) session.getAttribute("viaggioId"));
		for (PrenotazionePosto prenotazione : listaPrenotazioni) {
		    System.out.println("ID della prenotazione: " + prenotazione.getId());
		    System.out.println("Prezzo: " + prenotazione.getPrezzo());
		}
		
//		List<PostoASedere> listaPosti = new ArrayList<>();
//		for(int i=0; i<listaPrenotazioni.size(); i++) {
//			listaPosti.addAll(prenotazioneservice.findPostiByPrenotazioneId(listaPrenotazioni.get(i).getId()));
//		}
		
		List<PostoASedere> listaPosti = new ArrayList<>();
		for(int i=0; i<listaPrenotazioni.size(); i++) {
			listaPosti.addAll(prenotazioneservice.findPostiByPrenotazioneId(listaPrenotazioni.get(i).getId()));
		}
		List<Long> listaPostiId = new ArrayList<>();
		for(int i=0; i<listaPosti.size(); i++) {
			listaPostiId.add(listaPosti.get(i).getId());
		}
		
		for (PostoASedere posto : listaPosti) {
		    System.out.println("ID del posto: " + posto.getId());
		    
		}
//		List<PostoASedere> posti = prenotazione.getListaPosti();
//	    for (PostoASedere posto : posti) {
//	        System.out.println("ID Posto: " + posto.getId());
//	        System.out.println("Occupato: " + posto.isOccupato());
//	        System.out.println("Prezzo Posto: " + posto.getPrezzo());
//	    }
		m.addAttribute("posti", trenoservice.getAllPostiByVagoneId(id));
		m.addAttribute("postiOccupati", listaPostiId);
		
		for(int i=0; i<trenoservice.getAllPostiByVagoneId(id).size(); i++) {
			if(listaPostiId.contains(trenoservice.getAllPostiByVagoneId(id).get(i).getId())) {
				System.out.println("si" + trenoservice.getAllPostiByVagoneId(id).get(i));
			} else {
				System.out.println("no");
			}
		}
		return "postiview";
	}
	
	@PostMapping("prenotaPosto/postiview/ConfermaPrenotazione")
	public String confermaPrenotazione(@ModelAttribute("postiSelezionati") String posti, Model m) {
		System.out.println("bho" + session.getAttribute("viaggioId"));
		// crea un array di stringhe nel quale va a inserire tutte le sotto stringhe della 
		// stringa originale
		String[] numberStrings = posti.split(",");
		
		Long prenotazioneId = prenotazioneservice.addPrenotazione(prenotazione, numberStrings);
//		viaggioservice.updatePrenotazione(prenotazioneId, (Long) session.getAttribute("viaggioId"));
		viaggioservice.updatePrenotazione(prenotazioneId);
		utenteservice.updatePrenotazioniUtente(prenotazione, prenotazione.getPrezzo());

//        for (int i = 0; i < numberStrings.length; i++) {
//            	postoservice.OccupaPostoById(Long.parseLong(numberStrings[i]));    
//        }
		
		System.out.println(posti);
		return "redirect:/";
	}
	
//	@PostMapping("prenotaPosto/confermaPrenotazione")
//	public String conferemaPrenotazione(@ModelAttribute("postiSelezionati"))
	
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
}
