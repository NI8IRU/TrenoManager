package com.corso;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.corso.dao.TrenoDAO;
import com.corso.dao.TrenoDAOImpl;
import com.corso.service.TrenoService;

@Configuration
public class Beans {
	
	@Bean(name="trenoDao")
	public TrenoDAO getTrenoDao() {
		TrenoDAO trenodao = new TrenoDAOImpl();
		return trenodao;
	}
	
	@Bean(name ="trenoService")
	public TrenoService getTrenoService() {
		TrenoService trenoservice = new TrenoService();
		trenoservice.setDao(getTrenoDao());
		return trenoservice;
	}
}
