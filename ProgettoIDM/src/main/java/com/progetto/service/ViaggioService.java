package com.progetto.service;

import java.time.LocalDateTime;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.progetto.dao.ViaggioDao;
import com.progetto.model.Treno;
import com.progetto.model.Viaggio;
import com.progetto.vagoni.PostoASedere;

@Service
@Transactional
public class ViaggioService {

	@Autowired
	ViaggioDao viaggiodao;
	
public void addViaggio(LocalDateTime dataPartenza, LocalDateTime dataArrivo, String stazionePartenza, String stazioneDestinazione, String trenoId) {
		
		viaggiodao.addViaggio(dataPartenza, dataArrivo, stazionePartenza, stazioneDestinazione, trenoId);
	}

	public List<Viaggio> getAllViaggi() {
		
		return viaggiodao.getAllViaggi();
	}

	public List<PostoASedere> getAllPostiByViaggioId(Long id) {
		
		return viaggiodao.getAllPostiByViaggioId(id);
	}
	
	public Viaggio getViaggioById(Long id) {
		return viaggiodao.getViaggioById(id);
	
	}
	
	public Treno findTrenoByViaggio(Long id) {
		return viaggiodao.findTrenoByViaggio(id);
	}
	
	public void updatePrenotazione(Long idPrenotazione) {
		viaggiodao.updatePrenotazione(idPrenotazione);
	}
	
	
//	public void occupaPostiViaggio(String[] listaPosti, Long idViaggio) {
//		viaggiodao.occupaPostiViaggio(listaPosti, idViaggio);
//	}
}
