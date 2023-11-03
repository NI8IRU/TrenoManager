package com.progetto.test;

import com.progetto.builder.ConcreteBuilder;
import com.progetto.eccezioni.TrenoUniversalException;
import com.progetto.factory.FRFactory;
import com.progetto.model.Treno;

public class Test {

	public static void main(String[] args) throws TrenoUniversalException {
		FRFactory factory = new FRFactory();
		ConcreteBuilder builder = new ConcreteBuilder(factory);

		Treno treno = builder.assemblaTreno("hr");
		System.out.println(treno.toString());

	}

}
