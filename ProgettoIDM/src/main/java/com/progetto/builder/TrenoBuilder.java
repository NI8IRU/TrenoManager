package com.progetto.builder;

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
import com.progetto.vagoni.Vagone;

public abstract class TrenoBuilder {

	public Treno assemblaTreno(String stringId) throws TrenoUniversalException {
		
		int counter = 0;
		stringId = stringId.toUpperCase();
		char[] arrayStringId = stringId.toCharArray();
		
		try {
			if (!stringId.contains("H")) {
				throw new NoLocomotivaException(stringId);
			}
			
			if (stringId.contains("H") && !stringId.contains("C") && !stringId.contains("P") && !stringId.contains("R")) {
				throw new OnlyLocomotiveException(stringId);
			}
			
			if (!stringId.contains("P") && !stringId.contains("C")) {
				throw new NoPasseggeriWithRistoranteException(stringId);
			}
			
			for (char c : arrayStringId) {
				if (c == 'H') counter++;
			}
			
			if (counter > 2) {
				throw new LocomotivaSurplussException(stringId);
			}
			
			if (stringId.charAt(0) != 'H' || (stringId.charAt(0) != 'H' && stringId.charAt(stringId.length() - 1) != 'H')) {
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
		} catch (TrenoIrregolareException e) {
			System.out.println(e.soluzione());
			e.printStackTrace();
		}


		Treno t = new Treno();

		for (int i = 0; i < stringId.length(); i++) {

			char l = stringId.charAt(i);

			switch (l) {
			case 'H':
				t.addVagone(costruisciLocomotiva());
				break;
			case 'P':
				t.addVagone(costruisciPasseggeri());
				break;
			case 'R':
				t.addVagone(costruisciRistorante());
				break;
			case 'C':
				t.addVagone(costruisciCargo());
				break;
			default:
				throw new TrenoUniversalException("La composizione del treno è irregolare.");
			}
		}

		t.setMarca(getMarca());
		
		if(stringId.contains("P")) {
			t.setTipoTreno("Treno_Passeggeri");
		}else {
			t.setTipoTreno("Treno_Cargo");
		}
		return t;
	}

	protected abstract String getMarca();

	protected abstract Vagone costruisciLocomotiva();

	protected abstract Vagone costruisciPasseggeri();

	protected abstract Vagone costruisciRistorante();

	protected abstract Vagone costruisciCargo();
}
