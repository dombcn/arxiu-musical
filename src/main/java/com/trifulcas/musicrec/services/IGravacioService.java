package com.trifulcas.musicrec.services;

import java.util.List;
import com.trifulcas.musicrec.model.Gravacio;

public interface IGravacioService {
	
	List<Gravacio> getGravacions();
	
	List<Gravacio> getGravacionsInterpret(Integer idInterpret);
	
	List<Gravacio> getGravacionsCompositor(Integer idCompositor);
	
	List<Gravacio> getGravacionsGenere(Integer idGenere);
	
	void save(Gravacio gravacio);
	
	Gravacio getGravacio(Integer idGravacio);
	
	void delete(Gravacio gravacio);
	
}
