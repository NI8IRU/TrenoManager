package com.corso.dao;

import com.corso.treno.Treno;

public interface TrenoDAO {
	
	public Integer create(Treno bean);
	public void update(Treno bean);
	public void delete(Treno bean);
	public Treno findById(Integer id);
}