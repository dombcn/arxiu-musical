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
@Table(name = "autors")
public class Autor {

	@Id
	@Column(name = "idautor")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAutor;

	@NotNull
    @Size(min=1,message="El nom de l'autor és obligatori.")
	@Column(name = "nom", nullable=false)
	private String nom;
	
	@Column(name = "info")
	private String info;
	
	// Removed FetchType (Problem MultipleBagFetchException using Hibernate)
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "interpret",
		cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	private List<Gravacio> gravacionsInterpret;
	
	// Removed FetchType (Problem MultipleBagFetchException using Hibernate)
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "compositor",
		cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	private List<Gravacio> gravacionsCompositor;
	
	// Constructors ------------------
	
	public Autor() {
	}
	
	public Autor(String nom) {
		super();
		this.nom = nom;
	}
	
	// idAutor ------------------
	
	public Integer getIdAutor() {
		return idAutor;
	}
	
	public void setIdAutor(Integer idAutor) {
		this.idAutor = idAutor;
	}
	
	// nom ------------------
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	// info ------------------
	
	public String getInfo() {
		return info;
	}
	
	public void setInfo(String info) {
		this.info = info;
	}
	
	// gravacionsInterpret ------------------
	
	public void addGravacioInterpret(Gravacio gravacio) {
		if (gravacionsInterpret == null) {
			gravacionsInterpret = new ArrayList<Gravacio>();
		}
		gravacionsInterpret.add(gravacio);
		gravacio.setInterpret(this);
	}
	
	public List<Gravacio> getGravacionsInterpret() {
		return gravacionsInterpret;
	}
	
	public void setGravacionsInterpret(List<Gravacio> gravacions) {
		this.gravacionsInterpret = gravacions;
	}

	// gravacionsCompositor ------------------
	
	public void addGravacioCompositor(Gravacio gravacio) {
		if (gravacionsCompositor == null) {
			gravacionsCompositor = new ArrayList<Gravacio>();
		}
		gravacionsCompositor.add(gravacio);
		gravacio.setInterpret(this);
	}
	
	public List<Gravacio> getGravacionsCompositor() {
		return gravacionsCompositor;
	}
	
	public void setGravacionsCompositor(List<Gravacio> gravacions) {
		this.gravacionsCompositor = gravacions;
	}
	
	// see all ------------------
	
	@Override
	public String toString() {
		return "Autor [idAutor=" + idAutor + ", nom=" + nom + ", info=" + info + "]";
	}
    
}
