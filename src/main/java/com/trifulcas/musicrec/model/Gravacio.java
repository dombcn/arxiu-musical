package com.trifulcas.musicrec.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "gravacions")
public class Gravacio {

	@Id
	@Column(name = "idgravacio")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idGravacio;
	
	@NotNull
    @Size(min=1,message="El nom de l'àlbum és obligatori.")
	@Column(name = "album", nullable=false)
	private String album;
	
	@Column(name = "anygrav")
	private int anyGrav;

	@Column(name = "ntemes")
	private int numTemes;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="idinterpret", nullable=false)
	private Autor interpret;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="idcompositor", columnDefinition="integer", nullable=true)
	private Autor compositor;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="idgenere", columnDefinition="integer", nullable=true)
	private Genere genere;
	
	// Removed FetchType (Problem MultipleBagFetchException using Hibernate)
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "gravacio",
		cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	private List<LocalitzacioGravacio> localitzacioGravacions;
	
	// Constructors ------------------
	
	public Gravacio() {
	}
	
	public Gravacio(String album, int anyGrav, int numTemes) {
		super();
		this.album = album;
		this.anyGrav = anyGrav;
		this.numTemes = numTemes;
	}

	// idGravacio ------------------
	
	public Integer getIdGravacio() {
		return idGravacio;
	}
	
	public void setIdGravacio(Integer idGravacio) {
		this.idGravacio = idGravacio;
	}

	// album ------------------
	
	public String getAlbum() {
		return album;
	}
	
	public void setAlbum(String album) {
		this.album = album;
	}

	// anyGrav ------------------
	
	public int getAnyGrav() {
		return anyGrav;
	}
	
	public void setAnyGrav(int anyGrav) {
		this.anyGrav = anyGrav;
	}

	// numTemes ------------------
	
	public int getNumTemes() {
		return numTemes;
	}
	
	public void setNumTemes(int numTemes) {
		this.numTemes = numTemes;
	}

	// interpret ------------------
	
	public Autor getInterpret() {
		return interpret;
	}
	
	public void setInterpret(Autor interpret) {
		this.interpret = interpret;
	}

	// compositor ------------------
	
	public Autor getCompositor() {
		return compositor;
	}
	
	public void setCompositor(Autor compositor) {
		this.compositor = compositor;
	}

	// genere ------------------
	
	public Genere getGenere() {
		return genere;
	}
	
	public void setGenere(Genere genere) {
		this.genere = genere;
	}

	// localitzacioGravacions ------------------
	
	public void addLocalitzacioGravacio(LocalitzacioGravacio localitzacioGravacio) {
		if (localitzacioGravacions == null) {
			localitzacioGravacions = new ArrayList<LocalitzacioGravacio>();
		}
		localitzacioGravacions.add(localitzacioGravacio);
		localitzacioGravacio.setGravacio(this);
	}
	
	public List<LocalitzacioGravacio> getLocalitzacioGravacions() {
		return localitzacioGravacions;
	}
	
	public void setLocalitzacioGravacions(List<LocalitzacioGravacio> localitzacioGravacions) {
		this.localitzacioGravacions = localitzacioGravacions;
	}
	
	// albumInterpret (to fill forms) ------------------
	
	public String getAlbumInterpret() {
		String albumInterpret;
		if(album.length()>0) {
			albumInterpret = album + " (" + interpret.getNom() + ")";
		}
		else {
			albumInterpret = "??? (" + interpret.getNom() + ")";
		}
		return albumInterpret;
	}
	
	// see all ------------------
	
	@Override
	public String toString() {
		return "Gravacio [idGravacio=" + idGravacio + ", album=" + album 
				+ ", anyGrav=" + anyGrav + ", numTemes=" + numTemes + ", interpret=" + interpret 
				+ ", compositor=" + compositor + ", genere=" + genere + "]";
	}
	
}
