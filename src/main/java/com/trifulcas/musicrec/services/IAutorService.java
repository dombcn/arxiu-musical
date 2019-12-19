package com.trifulcas.musicrec.services;

import java.util.List;
import com.trifulcas.musicrec.model.Autor;

public interface IAutorService {
	
	List<Autor> getAutors();
	
	void save(Autor autor);
	
	Autor getAutor(Integer idAutor);
	
	void delete(Autor autor);
	
}
