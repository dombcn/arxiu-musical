package com.trifulcas.musicrec.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.trifulcas.musicrec.model.Localitzacio;

@Repository
public class LocalitzacioDAO implements ILocalitzacioDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Localitzacio> getLocalitzacions() {
		Session miSesion = sessionFactory.getCurrentSession();
		List<Localitzacio> localitzacions = miSesion.createQuery("FROM Localitzacio", Localitzacio.class).list();
		return localitzacions;
	}
	
	@Override
	public void save(Localitzacio localitzacio) {
		Session miSesion=sessionFactory.getCurrentSession();
		miSesion.saveOrUpdate(localitzacio);
	}
	
	@Override
	public Localitzacio getLocalitzacio(Integer idLocalitzacio) {
		Session miSesion=sessionFactory.getCurrentSession();
		return miSesion.get(Localitzacio.class,idLocalitzacio);
	}
	
	@Override
	public void delete(Localitzacio localitzacio) {
		Session miSesion=sessionFactory.getCurrentSession();
		miSesion.delete(localitzacio);
	}
	
}
