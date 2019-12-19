package com.trifulcas.musicrec.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.trifulcas.musicrec.dao.IFormatDAO;
import com.trifulcas.musicrec.model.Format;

@Service("formatService")
public class FormatService implements IFormatService {

	@Autowired
	private IFormatDAO formatDAO;
	
	@Override
	@Transactional
	public List<Format> getFormats() {
		return formatDAO.getFormats();
	}
	
	@Override
	@Transactional
	public void save(Format format) {
		formatDAO.save(format);
	}
	
	@Override
	@Transactional
	public Format getFormat(Integer idFormat) {
		return formatDAO.getFormat(idFormat);
	}
	
	@Override
	@Transactional
	public void delete(Format format) {
		formatDAO.delete(format);
	}

}
