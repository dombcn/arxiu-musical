package com.trifulcas.musicrec.dao;

import java.util.List;
import com.trifulcas.musicrec.model.Format;

public interface IFormatDAO {
	
	List<Format> getFormats();
	
	void save(Format format);
	
	Format getFormat(Integer idFormat);
	
	void delete(Format format);
	
}
