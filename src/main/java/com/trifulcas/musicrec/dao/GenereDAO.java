package com.trifulcas.musicrec.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.trifulcas.musicrec.model.Genere;

@Repository
public class GenereDAO implements IGenereDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Genere> getGeneres() {
		Session miSesion = sessionFactory.getCurrentSession();
		List<Genere> generes = miSesion.createQuery("FROM Genere", Genere.class).list();
		return generes;
	}
	
	@Override
	public void save(Genere genere) {
		Session miSesion=sessionFactory.getCurrentSession();
		miSesion.saveOrUpdate(genere);
	}
	
	@Override
	public Genere getGenere(Integer idGenere) {
		Session miSesion=sessionFactory.getCurrentSession();
		return miSesion.get(Genere.class,idGenere);
	}
	
	@Override
	public void delete(Genere genere) {
		Session miSesion=sessionFactory.getCurrentSession();
		miSesion.delete(genere);
	}
	
}
