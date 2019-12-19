package com.trifulcas.musicrec.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "localitzaciogravacions")
public class LocalitzacioGravacio {

	@Id
	@Column(name = "idlocgrav")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idLocGrav;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="idgravacio", nullable=false)
	private Gravacio gravacio;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="idlocalitzacio", nullable=false)
	private Localitzacio localitzacio;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="idformat", nullable=false)
	private Format format;
	
	// Constructors ------------------
	
	public LocalitzacioGravacio() {
		
	}

	// idLocGrav ------------------
	
	public Integer getIdLocGrav() {
		return idLocGrav;
	}
	
	public void setIdLocGrav(Integer idLocGrav) {
		this.idLocGrav = idLocGrav;
	}

	// gravacio ------------------
	
	public Gravacio getGravacio() {
		return gravacio;
	}
	
	public void setGravacio(Gravacio gravacio) {
		this.gravacio = gravacio;
	}

	// localitzacio ------------------
	
	public Localitzacio getLocalitzacio() {
		return localitzacio;
	}
	
	public void setLocalitzacio(Localitzacio localitzacio) {
		this.localitzacio = localitzacio;
	}

	// format ------------------
	
	public Format getFormat() {
		return format;
	}
	
	public void setFormat(Format format) {
		this.format = format;
	}
	
	// see all ------------------
	
	@Override
	public String toString() {
		return "Localitzacio Gravacio [idLocGrav=" + idLocGrav + ", gravacio=" + gravacio 
				+ ", localitzacio=" + localitzacio + ", format=" + format + "]";
	}
	
}
