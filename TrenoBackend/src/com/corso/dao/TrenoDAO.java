package com.corso.dao;

import java.util.List;

import com.corso.dto.TrenoDTO;
import com.corso.treno.Treno;

public interface TrenoDAO {
	
	public Integer create(TrenoDTO bean);
	public void update(TrenoDTO bean);
	public void delete(TrenoDTO bean);
	public TrenoDTO findById(Integer id);
	public List<Bean> findAll();
}