package com.progetto.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progetto.Colore;
import com.progetto.dao.ColoreDao;

@Service
@Transactional
public class ColoreService {

	@Autowired
	ColoreDao coloredao;
	
	public Colore addColore(Colore colore) {
		return coloredao.addColore(colore);
	}
}
