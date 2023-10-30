package com.progetto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progetto.dao.TrenoDAO;
import com.progetto.model.Treno;

@Service
public class TrenoService {

	@Autowired
	TrenoDAO trenoDAO;

	public void addTrenoFR(String stringa) {
		trenoDAO.addTrenoFR(stringa);
	}
	
	public void addTrenoTN(String stringa) {
		trenoDAO.addTrenoTN(stringa);
	}
	
//	public void addTreno(TrenoDTO treno) {
//		trenoDAO.addTreno(treno);
//	}

	public List<Treno> getAllTreno() {
		return trenoDAO.getAllTreno();
	}

	public Treno getTrenoById(Long id) {
		return trenoDAO.getTrenoById(id);
	}

	public void updateTreno(Treno treno) {
		trenoDAO.updateTreno(treno);
	}

	public void deleteTreno(Long id) {
		trenoDAO.deleteTreno(id);
	}
}