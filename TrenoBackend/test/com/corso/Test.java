package com.corso;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.corso.dao.Bean;
import com.corso.dto.TrenoDTO;
import com.corso.eccezioni.TrenoIrregolareException;
import com.corso.service.UtenteService;
import com.corso.treno.ConcreteBuilder;
import com.corso.treno.Treno;
import com.corso.treno.TrenoBuilder;
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
		
		UtenteService utenteService = new UtenteService();
		utenteService.creaAdmin("Test", "password", list);
	}
}
