package com.progetto.builder;

import com.progetto.eccezioni.TrenoIrregolareException;
import com.progetto.model.Treno;
import com.progetto.vagoni.Vagone;

public abstract class TrenoBuilder {

	public Treno assemblaTreno(String stringId) throws TrenoIrregolareException {

		stringId = stringId.toUpperCase();

		if (stringId.charAt(0) != 'H' || (stringId.charAt(0) != 'H' && stringId.charAt(stringId.length() - 1) != 'H')) {
			throw new TrenoIrregolareException("La locomotiva non è posizionata all'inizio e/o alla fine della coda.");
		}

		if (stringId.contains("C") && (stringId.contains("P") || stringId.contains("R"))) {
			throw new TrenoIrregolareException(
					"Il treno non può essere composto da Vagoni Cargo se vi sono Vagoni Passeggeri o Vagoni Ristorante");
		}

		int c = 0;
		for (int i = 0; i < stringId.length(); i++) {

			if ((i > 0 && i < stringId.length() - 1) && stringId.charAt(i) == 'H') {
				throw new TrenoIrregolareException(
						"La Locomotiva non può essere posizionata in mezzo ad altri vagoni.");
			}
			if (stringId.charAt(i) == 'R') {
				c++;
			}

			if (c > 1) {
				throw new TrenoIrregolareException("Il treno non può contenere più di un Vagone Ristorante");
			}

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
				throw new TrenoIrregolareException("La composizione del treno è irregolare.");
			}
		}

		t.setMarca(getMarca());
		return t;
	}

	protected abstract Integer getMarca();

	protected abstract Vagone costruisciLocomotiva();

	protected abstract Vagone costruisciPasseggeri();

	protected abstract Vagone costruisciRistorante();

	protected abstract Vagone costruisciCargo();
}
