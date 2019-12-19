package com.trifulcas.musicrec.dao;

import java.util.List;
import com.trifulcas.musicrec.model.Genere;

public interface IGenereDAO {
	
	List<Genere> getGeneres();
	
	void save(Genere genere);
	
	Genere getGenere(Integer idGenere);
	
	void delete(Genere genere);
	
}
