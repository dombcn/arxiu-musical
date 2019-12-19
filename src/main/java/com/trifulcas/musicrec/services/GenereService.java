package com.trifulcas.musicrec.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.trifulcas.musicrec.dao.IGenereDAO;
import com.trifulcas.musicrec.model.Genere;

@Service("genereService")
public class GenereService implements IGenereService {

	@Autowired
	private IGenereDAO genereDAO;
	
	@Override
	@Transactional
	public List<Genere> getGeneres() {
		return genereDAO.getGeneres();
	}
	
	@Override
	@Transactional
	public void save(Genere genere) {
		genereDAO.save(genere);
	}
	
	@Override
	@Transactional
	public Genere getGenere(Integer idGenere) {
		return genereDAO.getGenere(idGenere);
	}
	
	@Override
	@Transactional
	public void delete(Genere genere) {
		genereDAO.delete(genere);
	}

}
