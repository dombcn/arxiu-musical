package com.trifulcas.musicrec.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.trifulcas.musicrec.dao.IAutorDAO;
import com.trifulcas.musicrec.model.Autor;

@Service("autorService")
public class AutorService implements IAutorService {

	@Autowired
	private IAutorDAO autorDAO;
	
	@Override
	@Transactional
	public List<Autor> getAutors() {
		return autorDAO.getAutors();
	}
	
	@Override
	@Transactional
	public void save(Autor autor) {
		autorDAO.save(autor);
	}
	
	@Override
	@Transactional
	public Autor getAutor(Integer idAutor) {
		return autorDAO.getAutor(idAutor);
	}
	
	@Override
	@Transactional
	public void delete(Autor autor) {
		autorDAO.delete(autor);
	}

}
