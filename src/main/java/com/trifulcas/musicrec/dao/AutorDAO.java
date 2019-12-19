package com.trifulcas.musicrec.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.trifulcas.musicrec.model.Autor;

@Repository
public class AutorDAO implements IAutorDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Autor> getAutors() {
		Session miSesion = sessionFactory.getCurrentSession();
		List<Autor> autors = miSesion.createQuery("FROM Autor", Autor.class).list();
		return autors;
	}
	
	@Override
	public void save(Autor autor) {
		Session miSesion=sessionFactory.getCurrentSession();
		miSesion.saveOrUpdate(autor);
	}
	
	@Override
	public Autor getAutor(Integer idAutor) {
		Session miSesion=sessionFactory.getCurrentSession();
		return miSesion.get(Autor.class,idAutor);
	}
	
	@Override
	public void delete(Autor autor) {
		Session miSesion=sessionFactory.getCurrentSession();
		miSesion.delete(autor);
	}
	
}
