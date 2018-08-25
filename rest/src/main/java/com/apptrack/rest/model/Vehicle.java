package com.apptrack.rest.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;


/**
 * The persistent class for the vehicle database table.
 * 
 */
@Entity
@Table(name="vehicle")
@NamedQuery(name="Vehicle.findAll", query="SELECT v FROM Vehicle v")
public class Vehicle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer vehicleid;

	private Integer axisnumber;

	@Column(precision=10, scale=2)
	private BigDecimal capacity;

	private Integer designpbv;

	@Column(precision=10, scale=2)
	private BigDecimal height;

	@Column(name="long", precision=10, scale=2)
	private BigDecimal long_;

	@Column(nullable=false, length=4)
	private String model;

	@Column(nullable=false, length=10)
	private String plaque;

	private Integer tiresnumber;

	@Column(precision=10, scale=2)
	private BigDecimal width;

	//bi-directional many-to-one association to Trailer
	@OneToMany(mappedBy="vehicle")
	private Set<Trailer> trailers;

	//bi-directional many-to-one association to Traveloffercandidate
	@OneToMany(mappedBy="vehicle")
	private Set<Traveloffercandidate> traveloffercandidates;

	//bi-directional many-to-one association to Glossary
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="class")
	private Glossary glossary1;

	//bi-directional many-to-one association to Glossary
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="state")
	private Glossary glossary2;

	//bi-directional many-to-one association to Glossary
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="trailer")
	private Glossary glossary3;

	//bi-directional many-to-one association to Glossary
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="unit", nullable=false)
	private Glossary glossary4;

	//bi-directional many-to-one association to Vehicledocument
	@OneToMany(mappedBy="vehicle")
	private Set<Vehicledocument> vehicledocuments;

	//bi-directional many-to-one association to Vehicleimage
	@OneToMany(mappedBy="vehicle")
	private Set<Vehicleimage> vehicleimages;

	//bi-directional many-to-one association to Vehicleperson
	@OneToMany(mappedBy="vehicle")
	private Set<Vehicleperson> vehiclepersons;

	public Vehicle() {
	}

	public Integer getVehicleid() {
		return this.vehicleid;
	}

	public void setVehicleid(Integer vehicleid) {
		this.vehicleid = vehicleid;
	}

	public Integer getAxisnumber() {
		return this.axisnumber;
	}

	public void setAxisnumber(Integer axisnumber) {
		this.axisnumber = axisnumber;
	}

	public BigDecimal getCapacity() {
		return this.capacity;
	}

	public void setCapacity(BigDecimal capacity) {
		this.capacity = capacity;
	}

	public Integer getDesignpbv() {
		return this.designpbv;
	}

	public void setDesignpbv(Integer designpbv) {
		this.designpbv = designpbv;
	}

	public BigDecimal getHeight() {
		return this.height;
	}

	public void setHeight(BigDecimal height) {
		this.height = height;
	}

	public BigDecimal getLong_() {
		return this.long_;
	}

	public void setLong_(BigDecimal long_) {
		this.long_ = long_;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPlaque() {
		return this.plaque;
	}

	public void setPlaque(String plaque) {
		this.plaque = plaque;
	}

	public Integer getTiresnumber() {
		return this.tiresnumber;
	}

	public void setTiresnumber(Integer tiresnumber) {
		this.tiresnumber = tiresnumber;
	}

	public BigDecimal getWidth() {
		return this.width;
	}

	public void setWidth(BigDecimal width) {
		this.width = width;
	}

	public Set<Trailer> getTrailers() {
		return this.trailers;
	}

	public void setTrailers(Set<Trailer> trailers) {
		this.trailers = trailers;
	}

	public Trailer addTrailer(Trailer trailer) {
		getTrailers().add(trailer);
		trailer.setVehicle(this);

		return trailer;
	}

	public Trailer removeTrailer(Trailer trailer) {
		getTrailers().remove(trailer);
		trailer.setVehicle(null);

		return trailer;
	}

	public Set<Traveloffercandidate> getTraveloffercandidates() {
		return this.traveloffercandidates;
	}

	public void setTraveloffercandidates(Set<Traveloffercandidate> traveloffercandidates) {
		this.traveloffercandidates = traveloffercandidates;
	}

	public Traveloffercandidate addTraveloffercandidate(Traveloffercandidate traveloffercandidate) {
		getTraveloffercandidates().add(traveloffercandidate);
		traveloffercandidate.setVehicle(this);

		return traveloffercandidate;
	}

	public Traveloffercandidate removeTraveloffercandidate(Traveloffercandidate traveloffercandidate) {
		getTraveloffercandidates().remove(traveloffercandidate);
		traveloffercandidate.setVehicle(null);

		return traveloffercandidate;
	}

	public Glossary getGlossary1() {
		return this.glossary1;
	}

	public void setGlossary1(Glossary glossary1) {
		this.glossary1 = glossary1;
	}

	public Glossary getGlossary2() {
		return this.glossary2;
	}

	public void setGlossary2(Glossary glossary2) {
		this.glossary2 = glossary2;
	}

	public Glossary getGlossary3() {
		return this.glossary3;
	}

	public void setGlossary3(Glossary glossary3) {
		this.glossary3 = glossary3;
	}

	public Glossary getGlossary4() {
		return this.glossary4;
	}

	public void setGlossary4(Glossary glossary4) {
		this.glossary4 = glossary4;
	}

	public Set<Vehicledocument> getVehicledocuments() {
		return this.vehicledocuments;
	}

	public void setVehicledocuments(Set<Vehicledocument> vehicledocuments) {
		this.vehicledocuments = vehicledocuments;
	}

	public Vehicledocument addVehicledocument(Vehicledocument vehicledocument) {
		getVehicledocuments().add(vehicledocument);
		vehicledocument.setVehicle(this);

		return vehicledocument;
	}

	public Vehicledocument removeVehicledocument(Vehicledocument vehicledocument) {
		getVehicledocuments().remove(vehicledocument);
		vehicledocument.setVehicle(null);

		return vehicledocument;
	}

	public Set<Vehicleimage> getVehicleimages() {
		return this.vehicleimages;
	}

	public void setVehicleimages(Set<Vehicleimage> vehicleimages) {
		this.vehicleimages = vehicleimages;
	}

	public Vehicleimage addVehicleimage(Vehicleimage vehicleimage) {
		getVehicleimages().add(vehicleimage);
		vehicleimage.setVehicle(this);

		return vehicleimage;
	}

	public Vehicleimage removeVehicleimage(Vehicleimage vehicleimage) {
		getVehicleimages().remove(vehicleimage);
		vehicleimage.setVehicle(null);

		return vehicleimage;
	}

	public Set<Vehicleperson> getVehiclepersons() {
		return this.vehiclepersons;
	}

	public void setVehiclepersons(Set<Vehicleperson> vehiclepersons) {
		this.vehiclepersons = vehiclepersons;
	}

	public Vehicleperson addVehicleperson(Vehicleperson vehicleperson) {
		getVehiclepersons().add(vehicleperson);
		vehicleperson.setVehicle(this);

		return vehicleperson;
	}

	public Vehicleperson removeVehicleperson(Vehicleperson vehicleperson) {
		getVehiclepersons().remove(vehicleperson);
		vehicleperson.setVehicle(null);

		return vehicleperson;
	}

}