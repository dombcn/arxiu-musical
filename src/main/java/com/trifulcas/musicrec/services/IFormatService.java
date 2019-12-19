package com.trifulcas.musicrec.services;

import java.util.List;
import com.trifulcas.musicrec.model.Format;

public interface IFormatService {
	
	List<Format> getFormats();
	
	void save(Format format);
	
	Format getFormat(Integer idFormat);
	
	void delete(Format format);
	
}
