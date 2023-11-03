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
