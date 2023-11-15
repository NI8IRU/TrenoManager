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
import com.progetto.dao.ViaggioSearchDao;
import com.progetto.dao.ViaggioSearchRequest;
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

	@Autowired
	ViaggioSearchDao viaggioSearchDao;
	
	@Autowired
	ViaggioSearchRequest viaggioRequest;

	
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
		
		
	    return "redirect:/PagineJspCanoniche/viewViaggi/viewViaggi";
	}
	
	
	@GetMapping("/viaggi")
	public String getAllViaggi(Model m) {
		m.addAttribute("viaggi", viaggioservice.getAllViaggi());
//		session.removeAttribute("viaggioId");
		
		return "PagineJspCanoniche/viewViaggi/viewViaggi";
	}
	
	//CriteriaQuery
		@PostMapping("/searchViaggi")
	    public String eseguiQuery(
	    		Model m,
	    		@RequestParam String stazionePartenza,
	    		@RequestParam String stazioneDestinazione,
	    		@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime dataPartenza,
	    		@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime dataArrivo
	    		)
		{
	        
	        viaggioRequest.setStazioneDestinazione(stazioneDestinazione);
	        viaggioRequest.setStazionePartenza(stazionePartenza);
	        viaggioRequest.setDataPartenza(dataPartenza);
	        viaggioRequest.setDataArrivo(dataArrivo);
	        

	        List<Viaggio> risultatiQuery = viaggioSearchDao.
	        		findAllByCriteria(viaggioRequest);

	        for (Viaggio viaggio : risultatiQuery) {
	            System.out.println("viaggio" + viaggio);
	            // Aggiungi altre informazioni che vuoi stampare per ogni viaggio
	        }
	        System.out.println("stazioneDestinazione" + stazioneDestinazione);
	        // Fai qualcosa con i risultati, ad esempio passali al model per essere visualizzati nella tua vista
	        m.addAttribute("viaggiSearch", risultatiQuery);
	        
	        return "PagineJspCanoniche/viewViaggi/viewViaggi";
	    }
	
	@GetMapping("/prenotaPosto/{viaggioId}")
	public String prenotaPosto(@PathVariable(value="viaggioId") Long id, Model m) {		
		m.addAttribute("vagoni", trenoservice.getAllVagoniPasseggeriByTrenoId(viaggioservice.getViaggioById(id).getTreno().getId()));
		m.addAttribute("viaggioId", id);
		
		return "ScegliVagone";
		
	}
	
	@GetMapping("prenotaPosto/postiview/{viaggioId}/{vagoneId}")
	public String postiview(
			@PathVariable(value="viaggioId") Long viaggioId,
			@PathVariable(value = "vagoneId") Long vagoneId, 
			Model m
			)
	{
		
		List <PrenotazionePosto> listaPrenotazioni = 
				prenotazioneservice.findPrenotazioniByViaggioId(viaggioId);
		for (PrenotazionePosto prenotazione : listaPrenotazioni) {
		    System.out.println("ID della prenotazione: " + prenotazione.getId());
		    System.out.println("Prezzo: " + prenotazione.getPrezzo());
		}
		System.out.println("questo HHHHFHFHHFHFHHF:" + viaggioId);

		
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

		m.addAttribute("posti", trenoservice.getAllPostiByVagoneId(vagoneId));
		m.addAttribute("postiOccupati", listaPostiId);
		
		for(int i=0; i<trenoservice.getAllPostiByVagoneId(vagoneId).size(); i++) {
			if(listaPostiId.contains(trenoservice.getAllPostiByVagoneId(vagoneId).get(i).getId())) {
				System.out.println("si" + trenoservice.getAllPostiByVagoneId(vagoneId).get(i));
			} else {
				System.out.println("no");
			}
		}
		return "PagineJspCanoniche/scegliPosto/scegliPosto";
	}
	
	@PostMapping("prenotaPosto/postiview/{viaggioId}/ConfermaPrenotazione")
	public String confermaPrenotazione(
			@ModelAttribute("postiSelezionati") String posti,
			@PathVariable(value="viaggioId") Long viaggioId,
			Model m) {
		System.out.println("bho" + viaggioId);
		// crea un array di stringhe nel quale va a inserire tutte le sotto stringhe della 
		// stringa originale
		String[] numberStrings = posti.split(",");
		
		Long prenotazioneId = prenotazioneservice.addPrenotazione(prenotazione, numberStrings);
//		viaggioservice.updatePrenotazione(prenotazioneId, (Long) session.getAttribute("viaggioId"));
		viaggioservice.updatePrenotazione(prenotazioneId, viaggioId);
		utenteservice.updatePrenotazioniUtente(prenotazione, prenotazione.getPrezzo());
		System.out.println(posti);
		
		//cerca e aggiunge l'istanza di PrenotazionePosto al model
		prenotazione = prenotazioneservice.findPrenotazioneById(prenotazioneId);
		m.addAttribute("prenotazione", prenotazione);
		
		m.addAttribute("viaggio", viaggioservice.getViaggioById(viaggioId));
		
		
		return "prenotazioneConfermata";
	}
	
	
	
	

}
