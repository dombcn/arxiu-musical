package com.trifulcas.musicrec.dao;

import java.util.List;
import com.trifulcas.musicrec.model.Autor;

public interface IAutorDAO {
	
	List<Autor> getAutors();
	
	void save(Autor autor);
	
	Autor getAutor(Integer idAutor);
	
	void delete(Autor autor);
	
}
