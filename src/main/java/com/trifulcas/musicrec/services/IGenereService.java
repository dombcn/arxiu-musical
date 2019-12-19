package com.trifulcas.musicrec.services;

import java.util.List;
import com.trifulcas.musicrec.model.Genere;

public interface IGenereService {
	
	List<Genere> getGeneres();
	
	void save(Genere genere);
	
	Genere getGenere(Integer idGenere);
	
	void delete(Genere genere);
	
}
