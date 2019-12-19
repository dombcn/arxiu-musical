package com.trifulcas.musicrec.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "localitzacions")
public class Localitzacio {
	
	@Id
	@Column(name = "idlocalitzacio")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idLocalitzacio;

	@NotNull
    @Size(min=1,message="La descripció de la localització és obligatoria.")
	@Column(name = "desclloc", nullable=false)
	private String descLloc;
	
	// Removed FetchType (Problem MultipleBagFetchException using Hibernate)
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "localitzacio",
		cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	private List<LocalitzacioGravacio> localitzacioGravacions;
	
	// Constructors ------------------
	
	public Localitzacio() {
	}
	
	public Localitzacio(String descLloc) {
		super();
		this.descLloc = descLloc;
	}
	
	// idLocalitzacio ------------------
	
	public Integer getIdLocalitzacio() {
		return idLocalitzacio;
	}
	
	public void setIdLocalitzacio(Integer idLocalitzacio) {
		this.idLocalitzacio = idLocalitzacio;
	}

	// descLloc ------------------
	
	public String getDescLloc() {
		return descLloc;
	}
	
	public void setDescLloc(String descLloc) {
		this.descLloc = descLloc;
	}

	// localitzacioGravacions ------------------
	
	public void addLocalitzacioGravacio(LocalitzacioGravacio localitzacioGravacio) {
		if (localitzacioGravacions == null) {
			localitzacioGravacions = new ArrayList<LocalitzacioGravacio>();
		}
		localitzacioGravacions.add(localitzacioGravacio);
		localitzacioGravacio.setLocalitzacio(this);
	}
	
	public List<LocalitzacioGravacio> getLocalitzacioGravacions() {
		return localitzacioGravacions;
	}
	
	public void setLocalitzacioGravacions(List<LocalitzacioGravacio> localitzacioGravacions) {
		this.localitzacioGravacions = localitzacioGravacions;
	}
	
	// see all ------------------

	@Override
	public String toString() {
		return "Localitzacio [idLocalitzacio=" + idLocalitzacio + ", descLloc=" + descLloc + "]";
	}

}
