package com.trifulcas.musicrec.dao;

import java.util.List;
import com.trifulcas.musicrec.model.LocalitzacioGravacio;

public interface ILocalitzacioGravacioDAO {

	List<LocalitzacioGravacio> getLocGrav();
	
	List<LocalitzacioGravacio> getLocGravGravacio(Integer idGravacio);
	
	List<LocalitzacioGravacio> getLocGravLocalitzacio(Integer idLocalitzacio);
	
	List<LocalitzacioGravacio> getLocGravFormat(Integer idFormat);
	
	void save(LocalitzacioGravacio localitzacioGravacio);
	
	LocalitzacioGravacio getLocalitzacioGravacio(Integer idLocGrav);
	
	void delete(LocalitzacioGravacio localitzacioGravacio);
	
}
