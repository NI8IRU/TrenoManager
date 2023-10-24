package com.corso.service;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.corso.dao.Bean;
import com.corso.dao.TrenoDAO;
import com.corso.dao.TrenoDAOImpl;
import com.corso.dto.TrenoDTO;



@ComponentScan("com.corso.spring.web.controller.TrenoController.java")
public class TrenoService {
	
	private TrenoDAO dao = new TrenoDAOImpl();

	public void crea(TrenoDTO treno) {
		Integer id = dao.create(treno);
		System.out.println("Creato il treno con id: " + id);
	}
	
	public void update(TrenoDTO treno) {
		dao.update(treno);
		System.out.println("modificato il treno con id: " + treno.getId());
	}
	
	public void delete(TrenoDTO treno) {
		dao.delete(treno);
		System.out.println("Il treno: " + treno + " è stato correttamente eliminato");
	}
	
	public TrenoDTO findById(int id) {
		System.out.println("Il treno con id" + id + "è stato trovato");
		return dao.findById(id);
		
	}
	
	public List<Bean> findAll(){
		return dao.findAll();
	}
}
