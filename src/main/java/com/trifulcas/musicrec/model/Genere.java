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
@Table(name = "generes")
public class Genere {

	@Id
	@Column(name = "idgenere")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idGenere;

	@NotNull
    @Size(min=1,message="El nom del gènere és obligatori.")
	@Column(name = "nom", nullable=false)
	private String nom;
	
	// Removed FetchType (Problem MultipleBagFetchException using Hibernate)
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "genere",
		cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	private List<Gravacio> gravacions;
	
	// Constructors ------------------
	
	public Genere() {
	}
	
	public Genere(String nom) {
		super();
		this.nom = nom;
	}

	// idGenere ------------------
	
	public Integer getIdGenere() {
		return idGenere;
	}
	
	public void setIdGenere(Integer idGenere) {
		this.idGenere = idGenere;
	}

	// nom ------------------
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}

	// gravacions ------------------
	
	public void addGravacio(Gravacio gravacio) {
		if (gravacions == null) {
			gravacions = new ArrayList<Gravacio>();
		}
		gravacions.add(gravacio);
		gravacio.setGenere(this);
	}
	
	public List<Gravacio> getGravacions() {
		return gravacions;
	}
	
	public void setGravacions(List<Gravacio> gravacions) {
		this.gravacions = gravacions;
	}
	
	// see all ------------------
	
	@Override
	public String toString() {
		return "Genere [idGenere=" + idGenere + ", nom=" + nom + "]";
	}
    
}
