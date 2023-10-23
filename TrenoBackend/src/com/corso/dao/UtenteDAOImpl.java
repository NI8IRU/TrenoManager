package com.corso.dao;

import java.util.HashSet;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.corso.treno.Treno;
import com.corso.utente.Ruolo;
import com.corso.utente.Utente;

public class UtenteDAOImpl extends BaseDAO implements UtenteDAO{

	public Integer create(Utente bean){
		   return super.create(bean);
	   }
	 
	   
	   public Integer create2(Object bean){
		      Session session = factory.openSession();
		      Transaction tx = null;
		      Integer employeeID = null;
		      
		      try {
		         tx = session.beginTransaction();
		         
		         employeeID = (Integer) session.save(bean);
		         
		         tx.commit();
		      } catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      } finally {
		         session.close(); 
		      }
		      return employeeID;
		   }
	   
	   
	   public void update(Utente bean ){
		   super.update(bean);
	   }
	   
	   public void delete(Utente bean ){
		    
		   super.delete(bean);
	   }


	@Override
	public Utente findById(Integer id) {
		return (Utente) super.find(Utente.class, id);
		
	}


	@Override
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
	public Ruolo findRuoloByTipoRuolo(String tipoRuolo) {
	       Session session = factory.openSession();
		      Transaction tx = null;
		      Ruolo ruolo = null; 
		      try {
		         tx = session.beginTransaction();
		         
		         String hql = "from Ruolo where ruolo = :tipoRuolo ";
		         Query<Ruolo> query = session.createQuery(hql, Ruolo.class);
		         
		         query.setParameter("tipoRuolo", tipoRuolo);
		         
		         
		         ruolo = query.uniqueResult();
		         tx.commit();
		      } catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      } finally {
		         session.close(); 
		      }
		      return ruolo;
		   } 
	

	public Integer createUtente(String username, String password,  List<Treno> listaTreni){
		  Utente utente = null; 
		  Session session = factory.openSession();
	      Transaction tx = null;
	      Integer utenteID = null;
	      
	      try {
	         tx = session.beginTransaction();
	         utente = new Utente(username, password, new HashSet<>(), listaTreni);
	         
	         Ruolo ruoloUtente = this.findRuoloByTipoRuolo("Utente");
	         
	         utente.getRuoli().add(ruoloUtente);
	         
	         session.persist(utente);
	    
	         // session.update(employee); 
	         
	         tx.commit();
	         
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      
	      
	      return utenteID;
	   }
	
	public Integer createAdmin(String username, String password, List<Treno> listaTreni){
		  Utente utente = null; 
		  Session session = factory.openSession();
	      Transaction tx = null;
	      Integer utenteID = null;
	      
	      try {
	         tx = session.beginTransaction();
	         utente = new Utente(username, password, new HashSet<>(), listaTreni);
	         Ruolo ruoloAdmin = this.findRuoloByTipoRuolo("Admin");
	         Ruolo ruoloUtente = this.findRuoloByTipoRuolo("Utente");
	         utente.getRuoli().add(ruoloAdmin);
	         utente.getRuoli().add(ruoloUtente);
	         
	         session.persist(utente);
	    
	         // session.update(employee); 
	         
	         tx.commit();
	         
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      
	      
	      return utenteID;
	   }
	

}
