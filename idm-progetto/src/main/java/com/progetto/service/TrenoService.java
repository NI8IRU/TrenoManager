package com.progetto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progetto.dao.TrenoDAO;
import com.progetto.dto.TrenoDTO;

@Service
public class TrenoService {

	@Autowired
	TrenoDAO trenoDAO;

	public void addTreno(String stringa) {
		trenoDAO.addTreno(stringa);
	}
	
//	public void addTreno(TrenoDTO treno) {
//		trenoDAO.addTreno(treno);
//	}

	public List<TrenoDTO> getAllTreno() {
		return trenoDAO.getAllTreno();
	}

	public TrenoDTO getTrenoById(Long id) {
		return trenoDAO.getTrenoById(id);
	}

	public void updateTreno(TrenoDTO treno) {
		trenoDAO.updateTreno(treno);
	}

	public void deleteTreno(Long id) {
		trenoDAO.deleteTreno(id);
	}
}