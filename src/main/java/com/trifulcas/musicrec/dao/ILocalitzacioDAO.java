package com.trifulcas.musicrec.dao;

import java.util.List;
import com.trifulcas.musicrec.model.Localitzacio;

public interface ILocalitzacioDAO {
	
	List<Localitzacio> getLocalitzacions();
	
	void save(Localitzacio localitzacio);
	
	Localitzacio getLocalitzacio(Integer idLocalitzacio);
	
	void delete(Localitzacio localitzacio);
	
}