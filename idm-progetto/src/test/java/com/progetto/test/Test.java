package com.progetto.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.progetto.Colore;
import com.progetto.enumerati.ColoriEnum;


public class Test {

	
	
	public static void main(String[] args) {
		
		
		
	}
	
//	public void addRuoli() {
//	    Session session = factory.openSession();
//	    Transaction tx = null;
//
//	    try {
//	        tx = session.beginTransaction();
//
//	        // Cerca il ruolo "Admin" nel database
//	        Ruolo admin = (Ruolo) session.createQuery("FROM Ruolo WHERE ruolo = 'Admin'").uniqueResult();
//
//	        // Se non esiste, crea il ruolo "Admin"
//	        if (admin == null) {
//	            admin = new Ruolo();
//	            admin.setRuolo("Admin");
//	            session.persist(admin);
//	        }
//
//	        // Cerca il ruolo "Utente" nel database
//	        Ruolo utente = (Ruolo) session.createQuery("FROM Ruolo WHERE ruolo = 'Utente'").uniqueResult();
//
//	        // Se non esiste, crea il ruolo "Utente"
//	        if (utente == null) {
//	            utente = new Ruolo();
//	            utente.setRuolo("Utente");
//	            session.persist(utente);
//	        }
//
//	        tx.commit();
//	    } catch (HibernateException e) {
//	        if (tx != null) tx.rollback();
//	        e.printStackTrace();
//	    } finally {
//	        session.close();
//	    }
//	}


}
