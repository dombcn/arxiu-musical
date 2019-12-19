package com.trifulcas.musicrec.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.trifulcas.musicrec.model.LocalitzacioGravacio;

@Repository
public class LocalitzacioGravacioDAO implements ILocalitzacioGravacioDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<LocalitzacioGravacio> getLocGrav() {
		Session miSesion = sessionFactory.getCurrentSession();
		List<LocalitzacioGravacio> locGrav=miSesion.createQuery("FROM LocalitzacioGravacio",LocalitzacioGravacio.class).list();
		return locGrav;
	}

	@Override
	public List<LocalitzacioGravacio> getLocGravGravacio(Integer idGravacio) {
		Session miSesion = sessionFactory.getCurrentSession();
		List<LocalitzacioGravacio> locGrav=miSesion.createQuery("FROM LocalitzacioGravacio WHERE idgravacio=:idGravacio",
				LocalitzacioGravacio.class).setParameter("idGravacio",idGravacio).list();
		return locGrav;
	}

	@Override
	public List<LocalitzacioGravacio> getLocGravLocalitzacio(Integer idLocalitzacio) {
		Session miSesion = sessionFactory.getCurrentSession();
		List<LocalitzacioGravacio> locGrav=miSesion.createQuery("FROM LocalitzacioGravacio WHERE idlocalitzacio=:idLocalitzacio",
				LocalitzacioGravacio.class).setParameter("idLocalitzacio",idLocalitzacio).list();
		return locGrav;
	}

	@Override
	public List<LocalitzacioGravacio> getLocGravFormat(Integer idFormat) {
		Session miSesion = sessionFactory.getCurrentSession();
		List<LocalitzacioGravacio> locGrav=miSesion.createQuery("FROM LocalitzacioGravacio WHERE idformat=:idFormat",
				LocalitzacioGravacio.class).setParameter("idFormat",idFormat).list();
		return locGrav;
	}
	
	@Override
	public void save(LocalitzacioGravacio localitzacioGravacio) {
		Session miSesion = sessionFactory.getCurrentSession();
		miSesion.saveOrUpdate(localitzacioGravacio);
	}
	
	@Override
	public LocalitzacioGravacio getLocalitzacioGravacio(Integer idLocGrav) {
		Session miSesion = sessionFactory.getCurrentSession();
		return miSesion.get(LocalitzacioGravacio.class,idLocGrav);
	}
	
	@Override
	public void delete(LocalitzacioGravacio localitzacioGravacio) {
		Session miSesion = sessionFactory.getCurrentSession();
		miSesion.delete(localitzacioGravacio);
	}

}
