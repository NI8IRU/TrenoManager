package com.corso.service;

import java.util.List;

import com.corso.dao.Bean;
import com.corso.dao.TrenoDAO;
import com.corso.dao.TrenoDAOImpl;
import com.corso.treno.Treno;

public class TrenoService {
	
	private TrenoDAO dao = new TrenoDAOImpl();

	public void crea(Treno treno) {
		Integer id = dao.create(treno);
		System.out.println("Creato il treno con id: " + id);
	}
	
	public void update(Treno treno) {
		dao.update(treno);
		System.out.println("modificato il treno con id: " + treno.getId());
	}
	
	public void delete(Treno treno) {
		dao.delete(treno);
		System.out.println("Il treno: " + treno + " è stato correttamente eliminato");
	}
	
	public Treno findById(int id) {
		System.out.println("Il treno con id" + id + "è stato trovato");
		return dao.findById(id);
		
	}
	
	public List<Bean> findAll(String classe){
		return dao.findAll(classe);
	}
}
