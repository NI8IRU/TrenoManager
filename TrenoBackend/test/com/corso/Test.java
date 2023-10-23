package com.corso;

import com.corso.dao.Bean;
import com.corso.eccezioni.TrenoIrregolareException;
import com.corso.treno.ConcreteBuilder;
import com.corso.treno.Treno;
import com.corso.treno.TrenoBuilder;
import com.corso.vagoni.Vagone;
import com.corso.vagoni.vagone_factory.FRFactory;
import com.corso.vagoni.vagone_factory.VagoneFactory;

public class Test {

	public static void main(String[] args) {
		Treno treno = new Treno();
		VagoneFactory f = new FRFactory();
		TrenoBuilder tb = new ConcreteBuilder(f);
		try {
			treno = tb.assemblaTreno("HPPH");
		} catch (TrenoIrregolareException e) {
			e.printStackTrace();
		}

		System.out.println(treno.getMarca());
		for (Vagone vagone : treno.getTreno()) {
			System.out.println(vagone);
		}
		
		Bean treno22 = new Treno();
		System.out.println(treno22.getClass());
	}
}
