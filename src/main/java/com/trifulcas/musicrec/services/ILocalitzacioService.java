package com.trifulcas.musicrec.services;

import java.util.List;
import com.trifulcas.musicrec.model.Localitzacio;

public interface ILocalitzacioService {
	
	List<Localitzacio> getLocalitzacions();
	
	void save(Localitzacio localitzacio);
	
	Localitzacio getLocalitzacio(Integer idLocalitzacio);
	
	void delete(Localitzacio localitzacio);
	
}
