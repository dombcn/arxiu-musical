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
@Table(name = "formats")
public class Format {
	
	@Id
	@Column(name = "idformat")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idFormat;

	@NotNull
    @Size(min=1,message="El nom del format és obligatori.")
	@Column(name = "nom", nullable=false)
	private String nom;

	// Removed FetchType (Problem MultipleBagFetchException using Hibernate)
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "format",
		cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	private List<LocalitzacioGravacio> localitzacioGravacions;
	
	// Constructors ------------------
	
	public Format() {
	}
	
	public Format(String nom) {
		super();
		this.nom = nom;
	}

	// idFormat ------------------
	
	public Integer getIdFormat() {
		return idFormat;
	}
	
	public void setIdFormat(Integer idFormat) {
		this.idFormat = idFormat;
	}

	// nom ------------------
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}

	// localitzacioGravacions ------------------
	
	public void addLocalitzacioGravacio(LocalitzacioGravacio localitzacioGravacio) {
		if (localitzacioGravacions == null) {
			localitzacioGravacions = new ArrayList<LocalitzacioGravacio>();
		}
		localitzacioGravacions.add(localitzacioGravacio);
		localitzacioGravacio.setFormat(this);
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
		return "Format [idFormat=" + idFormat + ", nom=" + nom + "]";
	}

}
