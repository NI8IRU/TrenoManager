package com.corso;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.corso.dao.Bean;
import com.corso.dto.TrenoDTO;
import com.corso.eccezioni.TrenoIrregolareException;
import com.corso.service.TrenoService;
import com.corso.service.UtenteService;
import com.corso.treno.ConcreteBuilder;
import com.corso.treno.Treno;
import com.corso.treno.TrenoBuilder;
import com.corso.utente.Ruolo;
import com.corso.vagoni.Vagone;
import com.corso.vagoni.vagone_factory.FRFactory;
import com.corso.vagoni.vagone_factory.VagoneFactory;

public class Test {
	
	private static SessionFactory factory;


	public static void main(String[] args) {
		Treno treno = new Treno();
		VagoneFactory f = new FRFactory();
		TrenoBuilder tb = new ConcreteBuilder(f);
		try {
			treno = tb.assemblaTreno("HPPH");
		} catch (TrenoIrregolareException e) {
			e.printStackTrace();
		}

		System.out.println(treno.getMarca());
		for (Vagone vagone : treno.getTreno()) {
			System.out.println(vagone);
		}
		
		TrenoDTO treno2 = new TrenoDTO(null, 1, null, "HPPP", new Date(0));
		
		Bean treno22 = new Treno();
		System.out.println(treno22);
		
		List<TrenoDTO> list = new ArrayList<TrenoDTO>();
		list.add(treno2);
		list.add(treno2);
		
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
		}
		
		//creo un istanza di questa classe in modo tale da poter usare il metodo per creare i ruoli
		Test test = new Test();
		test.addRuoli();
		
		
		UtenteService utenteService = new UtenteService();
//		utenteService.creaUtente("utente2", "password", list);
		
		TrenoService trenoService = new TrenoService();
		System.out.println(trenoService.findAll());
		
		System.out.println(utenteService.findAll());
		
	}
	
	public void addRuoli() {
	    Session session = factory.openSession();
	    Transaction tx = null;

	    try {
	        tx = session.beginTransaction();

	        // Cerca il ruolo "Admin" nel database
	        Ruolo admin = (Ruolo) session.createQuery("FROM Ruolo WHERE ruolo = 'Admin'").uniqueResult();

	        // Se non esiste, crea il ruolo "Admin"
	        if (admin == null) {
	            admin = new Ruolo();
	            admin.setRuolo("Admin");
	            session.persist(admin);
	        }

	        // Cerca il ruolo "Utente" nel database
	        Ruolo utente = (Ruolo) session.createQuery("FROM Ruolo WHERE ruolo = 'Utente'").uniqueResult();

	        // Se non esiste, crea il ruolo "Utente"
	        if (utente == null) {
	            utente = new Ruolo();
	            utente.setRuolo("Utente");
	            session.persist(utente);
	        }

	        tx.commit();
	    } catch (HibernateException e) {
	        if (tx != null) tx.rollback();
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }
	}

}
