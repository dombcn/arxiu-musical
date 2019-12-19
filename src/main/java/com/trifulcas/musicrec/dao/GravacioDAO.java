package com.trifulcas.musicrec.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trifulcas.musicrec.model.Gravacio;

@Repository
public class GravacioDAO implements IGravacioDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Gravacio> getGravacions() {
		Session miSesion = sessionFactory.getCurrentSession();
		List<Gravacio> gravacions=miSesion.
				createQuery("FROM Gravacio",Gravacio.class).list();
		return gravacions;
	}

	@Override
	public List<Gravacio> getGravacionsInterpret(Integer idInterpret) {
		Session miSesion = sessionFactory.getCurrentSession();
		List<Gravacio> gravacions=miSesion.createQuery("FROM Gravacio WHERE idinterpret=:idInterpret",
						Gravacio.class).setParameter("idInterpret",idInterpret).list();
		return gravacions;
	}

	@Override
	public List<Gravacio> getGravacionsCompositor(Integer idCompositor) {
		Session miSesion = sessionFactory.getCurrentSession();
		List<Gravacio> gravacions=miSesion.createQuery("FROM Gravacio WHERE idcompositor=:idCompositor",
						Gravacio.class).setParameter("idCompositor",idCompositor).list();
		return gravacions;
	}

	@Override
	public List<Gravacio> getGravacionsGenere(Integer idGenere) {
		Session miSesion = sessionFactory.getCurrentSession();
		List<Gravacio> gravacions=miSesion.createQuery("FROM Gravacio WHERE idgenere=:idGenere",
						Gravacio.class).setParameter("idGenere",idGenere).list();
		return gravacions;
	}
	
	@Override
	public void save(Gravacio gravacio) {
		Session miSesion = sessionFactory.getCurrentSession();
		miSesion.saveOrUpdate(gravacio);
	}
	
	@Override
	public Gravacio getGravacio(Integer idGravacio) {
		Session miSesion = sessionFactory.getCurrentSession();
		return miSesion.get(Gravacio.class,idGravacio);
	}
	
	@Override
	public void delete(Gravacio gravacio) {
		Session miSesion = sessionFactory.getCurrentSession();
		miSesion.delete(gravacio);
	}

}
