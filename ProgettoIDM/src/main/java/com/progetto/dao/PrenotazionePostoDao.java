package com.progetto.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
import com.progetto.service.PostoService;
import com.progetto.vagoni.PostoASedere;


@Component
public class PrenotazionePostoDao {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Autowired
	PostoService postoservice;
	
	@Autowired
	SessionFactory factory;
	
	@Transactional
	public Long addPrenotazione(PrenotazionePosto prenotazione, String[] listaId) {
		
		List<PostoASedere> listaPosti = new ArrayList<>();
		float prezzo = 0;
		
		for(int i=0; i<listaId.length; i++) {
			PostoASedere posto = postoservice.findPostoById(Long.parseLong(listaId[i]));
			prezzo += posto.getPrezzo();
			listaPosti.add(posto);
		}
		
		prenotazione.setListaPosti(listaPosti);
		prenotazione.setPrezzo(prezzo);
		
		
		Serializable id = hibernateTemplate.save(prenotazione);

	    return (Long) id;
		
	}
	
	public PrenotazionePosto findPrenotazioneById(Long id) {
		return hibernateTemplate.get(PrenotazionePosto.class, id);
	}

	
	public List<PrenotazionePosto> findPrenotazioniByViaggioId(Long idViaggio) {
	    Session session = factory.openSession();
	    Transaction tx = null;
	    List<PrenotazionePosto> listaPrenotazioni = new ArrayList<>();
	    try {
	        tx = session.beginTransaction();
	        String hql = "SELECT p FROM Viaggio v JOIN v.listaPrenotazioni p WHERE v.id = :viaggioId";
	        Query<PrenotazionePosto> query = session.createQuery(hql, PrenotazionePosto.class);
	        query.setParameter("viaggioId", idViaggio);
	        listaPrenotazioni = query.getResultList();
	        tx.commit();
	    } catch (HibernateException e) {
	        if (tx != null) tx.rollback();
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listaPrenotazioni;
	}

	
	public List<PostoASedere> findPostiByPrenotazioneId(Long idPrenotazione) {
	    Session session = factory.openSession();
	    Transaction tx = null;
	    List<PostoASedere> listaPosti = new ArrayList<>();

	    try {
	        tx = session.beginTransaction();

	        String hql = "select p from PrenotazionePosto prenotazione join prenotazione.listaPosti p where prenotazione.id = :prenotazioneId";
	        Query<PostoASedere> query = session.createQuery(hql, PostoASedere.class);
	        query.setParameter("prenotazioneId", idPrenotazione);

	        listaPosti = query.getResultList();
	        tx.commit();
	    } catch (HibernateException e) {
	        if (tx != null) tx.rollback();
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	    return listaPosti;
	}


}
