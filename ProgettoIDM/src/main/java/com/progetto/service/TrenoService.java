package com.progetto.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progetto.dao.TrenoDAO;
import com.progetto.eccezioni.NoPasseggeriWithRistoranteException;
import com.progetto.eccezioni.PasseggeriAndCargoException;
import com.progetto.eccezioni.TrenoIrregolareException;
import com.progetto.eccezioni.TrenoUniversalException;
import com.progetto.eccezioni.locomotiva.LocomotivaFuoriPostoException;
import com.progetto.eccezioni.locomotiva.LocomotivaSurplussException;
import com.progetto.eccezioni.locomotiva.NoLocomotivaException;
import com.progetto.eccezioni.locomotiva.OnlyLocomotiveException;
import com.progetto.eccezioni.ristorante.RistoranteAndCargoException;
import com.progetto.eccezioni.ristorante.RistoranteSurplussException;
import com.progetto.model.Treno;
import com.progetto.vagoni.PostoASedere;
import com.progetto.vagoni.Vagone;

@Service
public class TrenoService {

	@Autowired
	TrenoDAO trenoDAO;
	
	@Autowired
	HttpSession session;

	public void addTrenoFR(String stringa) throws TrenoUniversalException {
		controlloAndCostruzione(stringa, "FR");
	}

	public void addTrenoTN(String stringa) throws TrenoUniversalException {
		controlloAndCostruzione(stringa, "TN");
	}

	public List<Treno> getAllTreno() {
		return trenoDAO.getAllTreno();
	}

	public Treno getTrenoById(Long id) {
		return trenoDAO.getTrenoById(id);
	}

	public List<Vagone> getAllVagoniByTrenoId(Long id) {
		return trenoDAO.getAllVagoniByTrenoId(id);
	}

	public List<Vagone> getAllVagoniPasseggeriByTrenoId(Long id) {
		return trenoDAO.getAllVagoniPasseggeriByTrenoId(id);
	}

	public List<PostoASedere> getAllPostiByVagoneId(Long id) {
		return trenoDAO.getAllPostiByVagoneId(id);
	}

	public void updateTreno(Treno treno) {
		trenoDAO.updateTreno(treno);
	}

	public void deleteTreno(Long id) {
		trenoDAO.deleteTreno(id);
	}

	private void controlloAndCostruzione(String stringId, String marca) {
		int counter = 0;
		stringId = stringId.toUpperCase();
		char[] arrayStringId = stringId.toCharArray();

		try {
			if (!stringId.contains("H")) {
				throw new NoLocomotivaException(stringId);
			}

			if (stringId.contains("H") && !stringId.contains("C") && !stringId.contains("P")
					&& !stringId.contains("R")) {
				throw new OnlyLocomotiveException(stringId);
			}

			if (!stringId.contains("P") && !stringId.contains("C")) {
				throw new NoPasseggeriWithRistoranteException(stringId);
			}

			for (char c : arrayStringId) {
				if (c == 'H')
					counter++;
			}

			if (counter > 2) {
				throw new LocomotivaSurplussException(stringId);
			}

			if (stringId.charAt(0) != 'H'
					|| (stringId.charAt(0) != 'H' && stringId.charAt(stringId.length() - 1) != 'H')) {
				throw new LocomotivaFuoriPostoException(stringId);
			}

			if (stringId.contains("C") && stringId.contains("R")) {
				throw new RistoranteAndCargoException(stringId);
			}

			int c = 0;
			for (int i = 0; i < stringId.length(); i++) {

				if ((i > 0 && i < stringId.length() - 1) && stringId.charAt(i) == 'H') {
					throw new LocomotivaFuoriPostoException(stringId);
				}
				if (stringId.charAt(i) == 'R') {
					c++;
				}

				if (c > 1) {
					throw new RistoranteSurplussException(stringId);
				}
			}

			if (stringId.contains("P") && stringId.contains("C")) {
				throw new PasseggeriAndCargoException(stringId);
			}
			
			if (unallowedChars(stringId)) {
				throw new TrenoUniversalException(stringId);
			}
			
			if (marca.equals("FR")) {
				trenoDAO.addTrenoFR(stringId);
				session.setAttribute("successMsg", "Treno FR inserito con successo");
			}
			
			if (marca.equals("TN")) {
				trenoDAO.addTrenoTN(stringId);
				session.setAttribute("successMsg", "Treno TN inserito con successo");
			}
		} catch (TrenoIrregolareException e) {
			System.out.println(e.soluzione());
			session.setAttribute("msg", e.soluzione());
			e.printStackTrace();
		} catch (TrenoUniversalException e) {
			System.out.println("La sigla contiene caratteri non ammessi, caratteri ammessi: 'H,P,R,C'");
			session.setAttribute("msg", "La sigla contiene caratteri non ammessi, caratteri ammessi: 'H,P,R,C'");
			e.printStackTrace();
		}
	}

	private boolean unallowedChars(String stringId) {
		ArrayList<String> caratteriConcessi = new ArrayList<String>(Arrays.asList("H", "P", "R", "C"));
		String[] arrayStringId = stringId.split("");
		
		for (String c : arrayStringId) {
			if (!caratteriConcessi.contains(c)) {
				return true;
			}
		}
		return false;
	}
	
	public List<Treno> getAllTrenoByUtenteId(Long id) {
		return trenoDAO.getAllTrenoByUtenteId(id);

	}
}