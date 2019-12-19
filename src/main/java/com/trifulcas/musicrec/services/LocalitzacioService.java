package com.trifulcas.musicrec.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.trifulcas.musicrec.dao.ILocalitzacioDAO;
import com.trifulcas.musicrec.model.Localitzacio;

@Service("localitzacioService")
public class LocalitzacioService implements ILocalitzacioService {

	@Autowired
	private ILocalitzacioDAO localitzacioDAO;
	
	@Override
	@Transactional
	public List<Localitzacio> getLocalitzacions() {
		return localitzacioDAO.getLocalitzacions();
	}
	
	@Override
	@Transactional
	public void save(Localitzacio localitzacio) {
		localitzacioDAO.save(localitzacio);
	}
	
	@Override
	@Transactional
	public Localitzacio getLocalitzacio(Integer idLocalitzacio) {
		return localitzacioDAO.getLocalitzacio(idLocalitzacio);
	}
	
	@Override
	@Transactional
	public void delete(Localitzacio localitzacio) {
		localitzacioDAO.delete(localitzacio);
	}

}
