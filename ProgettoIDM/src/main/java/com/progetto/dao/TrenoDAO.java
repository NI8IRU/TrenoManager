package com.progetto.dao;

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

import com.progetto.builder.ConcreteBuilder;
import com.progetto.eccezioni.TrenoIrregolareException;
import com.progetto.factory.FRFactory;
import com.progetto.factory.TNFactory;
import com.progetto.model.Treno;
import com.progetto.model.Utente;
import com.progetto.service.UtenteService;
import com.progetto.vagoni.PostoASedere;
import com.progetto.vagoni.Vagone;

@Component
public class TrenoDAO {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Autowired
	UtenteService utenteservice;
	
	@Autowired 
	HttpSession session;
	

	@Autowired
	SessionFactory factory;
	
	@Autowired
	ColoreDao coloredao;

	@Transactional
	public void addTrenoFR(String stringa) {
		FRFactory frFactory = new FRFactory();
		
		ConcreteBuilder builder = new ConcreteBuilder(frFactory);
		Treno treno = new Treno();
		try {
			treno = builder.assemblaTreno(stringa);
		} catch (TrenoIrregolareException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println(treno);
		
		for(int i=0; i<treno.getTreno().size(); i++) {
			coloredao.addColore(treno.getTreno().get(i).getColore());
		}
		
		Utente utenteLoggato = (Utente) session.getAttribute("utenteLoggato");
//		utenteLoggato.getListaTreni().add(treno);
//		utenteservice.updateUtente(utenteLoggato);
		Utente utenteStaccato = utenteservice.getUtenteById(utenteLoggato.getId());
	    utenteStaccato.getListaTreni().add(treno);
	    utenteservice.updateUtente(utenteStaccato);
		hibernateTemplate.save(treno);
	}
	
	@Transactional
	public void addTrenoTN(String stringa) {
		TNFactory tnFactory = new TNFactory();
		
		ConcreteBuilder builder = new ConcreteBuilder(tnFactory);
		Treno treno = new Treno();
		try {
			treno = builder.assemblaTreno(stringa);
		} catch (TrenoIrregolareException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println(treno);
		for(int i=0; i<treno.getTreno().size(); i++) {
			coloredao.addColore(treno.getTreno().get(i).getColore());
		}
		
		Utente utenteLoggato = (Utente) session.getAttribute("utenteLoggato");
//		utenteLoggato.getListaTreni().add(treno);
//		utenteservice.updateUtente(utenteLoggato);
		Utente utenteStaccato = utenteservice.getUtenteById(utenteLoggato.getId());
	    utenteStaccato.getListaTreni().add(treno);
	    utenteservice.updateUtente(utenteStaccato);
		hibernateTemplate.save(treno);
	}
	
	
//	@Transactional
//	public void addTreno(TrenoDTO treno) {
//		hibernateTemplate.save(treno);
//	}

	public List<Treno> getAllTreno() {
		return hibernateTemplate.loadAll(Treno.class);
	}

	@Transactional
	public Treno getTrenoById(Long id) {
		Treno treno= hibernateTemplate.get(Treno.class, id);
		return treno;
	}
	

	public List<Vagone> getAllVagoniByTrenoId(Long id){
		Session session = factory.openSession();
	      Transaction tx = null;
	      List<Vagone> listavagoni = null; 
	      try {
	         tx = session.beginTransaction();
	         
	         String hql = "from Vagone where TrenoId = :id";
	         Query<Vagone> query = session.createQuery(hql, Vagone.class);
	         
	         query.setParameter("id", id);
	         
	         
	         listavagoni = query.getResultList();
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return listavagoni;
	}

	public List<Vagone> getAllVagoniPasseggeriByTrenoId(Long id){
		Session session = factory.openSession();
	      Transaction tx = null;
	      List<Vagone> listavagoni = null; 
	      try {
	         tx = session.beginTransaction();
	         
	         String hql = "from Vagone where TrenoId = :id and tipoVagone = 'PASSEGGERI'";
	         Query<Vagone> query = session.createQuery(hql, Vagone.class);
	         
	         query.setParameter("id", id);
	         
	         
	         listavagoni = query.getResultList();
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return listavagoni;
	}

	public List<PostoASedere> getAllPostiByVagoneId(Long id){
		Session session = factory.openSession();
	      Transaction tx = null;
	      List<PostoASedere> listaposti = null; 
	      try {
	         tx = session.beginTransaction();
	         
	         String hql = "from PostoASedere where VagoneId = :id";
	         Query<PostoASedere> query = session.createQuery(hql, PostoASedere.class);
	         
	         query.setParameter("id", id);
	         
	         
	         listaposti = query.getResultList();
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return listaposti;
	}

	
	@Transactional
	public void updateTreno(Treno treno) {
		hibernateTemplate.update(treno);
	}

	@Transactional
	public void deleteTreno(Long id) {
		hibernateTemplate.delete(hibernateTemplate.load(Treno.class, id));
	}
	
	
}

