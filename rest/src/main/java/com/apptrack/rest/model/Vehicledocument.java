package com.apptrack.rest.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the vehicledocument database table.
 * 
 */
@Entity
@Table(name="vehicledocument")
@NamedQuery(name="Vehicledocument.findAll", query="SELECT v FROM Vehicledocument v")
public class Vehicledocument implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer vehicledocumentid;

	@Column(nullable=false)
	private byte[] image;

	//bi-directional many-to-one association to Glossary
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="slide", nullable=false)
	private Glossary glossary;

	//bi-directional many-to-one association to Profiledocument
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="profiledocumentid")
	private Profiledocument profiledocument;

	//bi-directional many-to-one association to Vehicle
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="vehicleid")
	private Vehicle vehicle;

	public Vehicledocument() {
	}

	public Integer getVehicledocumentid() {
		return this.vehicledocumentid;
	}

	public void setVehicledocumentid(Integer vehicledocumentid) {
		this.vehicledocumentid = vehicledocumentid;
	}

	public byte[] getImage() {
		return this.image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Glossary getGlossary() {
		return this.glossary;
	}

	public void setGlossary(Glossary glossary) {
		this.glossary = glossary;
	}

	public Profiledocument getProfiledocument() {
		return this.profiledocument;
	}

	public void setProfiledocument(Profiledocument profiledocument) {
		this.profiledocument = profiledocument;
	}

	public Vehicle getVehicle() {
		return this.vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

}