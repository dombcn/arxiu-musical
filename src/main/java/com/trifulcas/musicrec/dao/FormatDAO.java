package com.trifulcas.musicrec.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.trifulcas.musicrec.model.Format;

@Repository
public class FormatDAO implements IFormatDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Format> getFormats() {
		Session miSesion = sessionFactory.getCurrentSession();
		List<Format> formats = miSesion.createQuery("FROM Format", Format.class).list();
		return formats;
	}
	
	@Override
	public void save(Format format) {
		Session miSesion=sessionFactory.getCurrentSession();
		miSesion.saveOrUpdate(format);
	}
	
	@Override
	public Format getFormat(Integer idFormat) {
		Session miSesion=sessionFactory.getCurrentSession();
		return miSesion.get(Format.class,idFormat);
	}
	
	@Override
	public void delete(Format format) {
		Session miSesion=sessionFactory.getCurrentSession();
		miSesion.delete(format);
	}
	
}
