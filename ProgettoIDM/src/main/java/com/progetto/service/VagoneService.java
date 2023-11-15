package com.progetto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progetto.dao.VagoneDao;
import com.progetto.vagoni.Vagone;

@Service
public class VagoneService {
	
	@Autowired
	VagoneDao vagonedao;
	
	public Vagone findVagoneById(Long id) {
		return vagonedao.findVagoneById(id);
	}
}
