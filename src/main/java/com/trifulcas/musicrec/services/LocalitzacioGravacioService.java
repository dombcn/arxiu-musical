package com.trifulcas.musicrec.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.trifulcas.musicrec.dao.ILocalitzacioGravacioDAO;
import com.trifulcas.musicrec.model.LocalitzacioGravacio;

@Service("localitzacioGravacioService")
public class LocalitzacioGravacioService implements ILocalitzacioGravacioService {

	@Autowired
	private ILocalitzacioGravacioDAO localitzacioGravacioDAO;
	
	@Override
	@Transactional
	public List<LocalitzacioGravacio> getLocGrav() {
		return localitzacioGravacioDAO.getLocGrav();
	}
	
	@Override
	@Transactional
	public List<LocalitzacioGravacio> getLocGravGravacio(Integer idGravacio) {
		return localitzacioGravacioDAO.getLocGravGravacio(idGravacio);
	}
	
	@Override
	@Transactional
	public List<LocalitzacioGravacio> getLocGravLocalitzacio(Integer idLocalitzacio) {
		return localitzacioGravacioDAO.getLocGravLocalitzacio(idLocalitzacio);
	}
	
	@Override
	@Transactional
	public List<LocalitzacioGravacio> getLocGravFormat(Integer idFormat) {
		return localitzacioGravacioDAO.getLocGravFormat(idFormat);
	}
	
	@Override
	@Transactional
	public void save(LocalitzacioGravacio localitzacioGravacio) {
		localitzacioGravacioDAO.save(localitzacioGravacio);
	}
	
	@Override
	@Transactional
	public LocalitzacioGravacio getLocalitzacioGravacio(Integer idLocGrav) {
		return localitzacioGravacioDAO.getLocalitzacioGravacio(idLocGrav);
	}
	
	@Override
	@Transactional
	public void delete(LocalitzacioGravacio localitzacioGravacio) {
		localitzacioGravacioDAO.delete(localitzacioGravacio);
	}

}
