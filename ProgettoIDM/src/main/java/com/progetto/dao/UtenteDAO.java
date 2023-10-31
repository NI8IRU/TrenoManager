package com.progetto.dao;

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

import com.progetto.model.Utente;

@Component
public class UtenteDAO {
	
	@Autowired
	SessionFactory factory;

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void addAdmin(Utente utente)  {
		if(findUtenteByUsername(utente.getUsername()) == null) {
			utente.setRuolo("Admin");
			hibernateTemplate.save(utente);
		}
		
	}

	
	@Transactional
	public void addUtente(Utente utente) {
		if(findUtenteByUsername(utente.getUsername()) == null) {
			utente.setRuolo("Utente");
			hibernateTemplate.save(utente);
		}
	}

	public List<Utente> getAllUtente() {
		return hibernateTemplate.loadAll(Utente.class);
	}

	@Transactional
	public Utente getUtenteById(Long id) {

		Utente utente = hibernateTemplate.get(Utente.class, id);
		return utente;
	}

	@Transactional
	public void updateUtente(Utente utente) {
		hibernateTemplate.update(utente);
	}

	@Transactional
	public void deleteUtente(Long id) {
		hibernateTemplate.delete(hibernateTemplate.load(Utente.class, id));
	}
	
	public Utente findUtenteByUsername(String username) {
	       Session session = factory.openSession();
		      Transaction tx = null;
		      Utente utente = null; 
		      try {
		         tx = session.beginTransaction();
		         
		         String hql = "from Utente where username = :username";
		         Query<Utente> query = session.createQuery(hql, Utente.class);
		         
		         query.setParameter("username", username);
		         
		         
		         utente = query.uniqueResult();
		         tx.commit();
		      } catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      } finally {
		         session.close(); 
		      }
		      return utente;
		   } 

	
//	public Utente loginUtente(String username, String password) {
//		Session session = factory.openSession();
//	      Transaction tx = null;
//	      Utente utente = null; 
//	      try {
//	         tx = session.beginTransaction();
//	         
//	         String hql = "from Utente where username = :username and password = :password";
//	         Query<Utente> query = session.createQuery(hql, Utente.class);
//	         
//	         query.setParameter("username", username);
//	         query.setParameter("passsword", password);
//	   
//	         utente = query.uniqueResult();
//	         tx.commit();
//	      } catch (HibernateException e) {
//	         if (tx!=null) tx.rollback();
//	         e.printStackTrace(); 
//	      } finally {
//	         session.close(); 
//	      }
//	      return utente;
//		
//		
//	}
}
