package com.corso.dao;

import java.util.List;

import com.corso.treno.Treno;

public interface TrenoDAO {
	
	public Integer create(Treno bean);
	public void update(Treno bean);
	public void delete(Treno bean);
	public Treno findById(Integer id);
	public List<Bean> findAll(String classe);
}