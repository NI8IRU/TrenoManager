package com.progetto.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progetto.dao.PostoDao;
import com.progetto.vagoni.PostoASedere;

@Service
public class PostoService {

	@Autowired
	PostoDao postodao;
	
//	public void OccupaPostoById(Long id) {
//		postodao.OccupaPostoById(id);
//	}

	public PostoASedere findPostoById(Long id) {
		return postodao.findPostoById(id);
			  
	}
	
}
