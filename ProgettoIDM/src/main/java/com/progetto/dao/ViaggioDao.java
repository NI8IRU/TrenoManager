package com.progetto.dao;

import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import com.progetto.model.PrenotazionePosto;
import com.progetto.model.Treno;
import com.progetto.model.Viaggio;
import com.progetto.service.PostoService;
import com.progetto.service.PrenotazionePostoService;
import com.progetto.service.TrenoService;
import com.progetto.vagoni.PostoASedere;

@Component
@Transactional
public class ViaggioDao {
	
	@Autowired
	SessionFactory factory;
	
	@Autowired 
	HttpSession session;

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Autowired
	Viaggio viaggio;
	
	@Autowired
	TrenoService trenoservice;
	
	@Autowired 
	PostoService postoservice;
	
	@Autowired
	PrenotazionePostoService prenotazioneservice;

	
	@Transactional
	public void addViaggio(LocalDateTime dataPartenza, LocalDateTime dataArrivo, String stazionePartenza, String stazioneDestinazione, String trenoId)  {
		viaggio.setDataPartenza(dataPartenza);
		viaggio.setDataArrivo(dataArrivo);
		viaggio.setStazionePartenza(stazionePartenza);
		viaggio.setStazioneDestinazione(stazioneDestinazione);
		
		trenoservice.getTrenoById(Long.parseLong(trenoId)).getListaViaggi().add(viaggio);
	}

	public List<Viaggio> getAllViaggi() {
		return hibernateTemplate.loadAll(Viaggio.class);
	}
	
	public Viaggio getViaggioById(Long id) {
		return hibernateTemplate.get(Viaggio.class, id);
	
	}

	public List<PostoASedere> getAllPostiByViaggioId(Long id) {

		Session session = factory.openSession();
		Transaction tx = null;
		List<PostoASedere> listaposti = null; 

		try {
		    tx = session.beginTransaction();
		    
		    Long idViaggio = id;
		    
		    String hql = "SELECT p " +
		                 "FROM Viaggio v " +
		                 "JOIN v.listaPosti p " +
		                 "WHERE v.id = :viaggioId";
		    
		    Query<PostoASedere> query = session.createQuery(hql, PostoASedere.class);
		    query.setParameter("viaggioId", idViaggio);
		    
		    listaposti = query.getResultList();
		    tx.commit();
		} catch (HibernateException e) {
		    if (tx != null) tx.rollback();
		    e.printStackTrace(); 
		} finally {
		    session.close(); 
		}
		return listaposti;
	}
	
	public Viaggio findViaggioById(Long id) {
		return hibernateTemplate.get(Viaggio.class, id);
		
	}
	
	public void updateViaggio(Viaggio viaggio) {
		hibernateTemplate.update(viaggio);
	}
	
	public Treno findTrenoByViaggio(Long id) {
	       Session session = factory.openSession();
		      Transaction tx = null;
		      Treno treno= null; 
		      try {
		         tx = session.beginTransaction();
		         
		         String hql = "SELECT t.treno.id FROM Viaggio v JOIN v.treno t WHERE v.id = :viaggioId";
		         Query<Treno> query = session.createQuery(hql, Treno.class);
		         
		         query.setParameter("viaggioId", id);
		         
		         
		         treno = query.uniqueResult();
		         tx.commit();
		      } catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      } finally {
		         session.close(); 
		      }
		      return treno;
		   } 
	
	public void updatePrenotazione(Long idPrenotazione) {
	    Long idViaggio = (Long) session.getAttribute("viaggioId");
	    Viaggio viaggio = findViaggioById(idViaggio);
	    PrenotazionePosto prenotazione = prenotazioneservice.findPrenotazioneById(idPrenotazione);

	    viaggio.getListaPrenotazioni().add(prenotazione);

	    updateViaggio(viaggio);
	}	
}