package com.trifulcas.musicrec.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.trifulcas.musicrec.dao.IGravacioDAO;
import com.trifulcas.musicrec.model.Gravacio;

@Service("gravacioService")
public class GravacioService implements IGravacioService {

	@Autowired
	private IGravacioDAO gravacioDAO;
	
	@Override
	@Transactional
	public List<Gravacio> getGravacions() {
		return gravacioDAO.getGravacions();
	}
	
	@Override
	@Transactional
	public List<Gravacio> getGravacionsInterpret(Integer idInterpret) {
		return gravacioDAO.getGravacionsInterpret(idInterpret);
	}
	
	@Override
	@Transactional
	public List<Gravacio> getGravacionsCompositor(Integer idCompositor) {
		return gravacioDAO.getGravacionsCompositor(idCompositor);
	}
	
	@Override
	@Transactional
	public List<Gravacio> getGravacionsGenere(Integer idGenere) {
		return gravacioDAO.getGravacionsGenere(idGenere);
	}
	
	@Override
	@Transactional
	public void save(Gravacio gravacio) {
		gravacioDAO.save(gravacio);
	}
	
	@Override
	@Transactional
	public Gravacio getGravacio(Integer idGravacio) {
		return gravacioDAO.getGravacio(idGravacio);
	}
	
	@Override
	@Transactional
	public void delete(Gravacio gravacio) {
		gravacioDAO.delete(gravacio);
	}

}

