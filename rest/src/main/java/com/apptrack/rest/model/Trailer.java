package com.apptrack.rest.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;


/**
 * The persistent class for the trailer database table.
 * 
 */
@Entity
@Table(name="trailer")
@NamedQuery(name="Trailer.findAll", query="SELECT t FROM Trailer t")
public class Trailer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer trailerid;

	private Integer axisnumber;

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

	//bi-directional many-to-one association to Glossary
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="class", nullable=false)
	private Glossary glossary1;

	//bi-directional many-to-one association to Glossary
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="state", nullable=false)
	private Glossary glossary2;

	//bi-directional many-to-one association to Glossary
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="trailer", nullable=false)
	private Glossary glossary3;

	//bi-directional many-to-one association to Vehicle
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="vehicleid")
	private Vehicle vehicle;

	//bi-directional many-to-one association to Trailercapacity
	@OneToMany(mappedBy="trailer")
	private Set<Trailercapacity> trailercapacities;

	public Trailer() {
	}

	public Integer getTrailerid() {
		return this.trailerid;
	}

	public void setTrailerid(Integer trailerid) {
		this.trailerid = trailerid;
	}

	public Integer getAxisnumber() {
		return this.axisnumber;
	}

	public void setAxisnumber(Integer axisnumber) {
		this.axisnumber = axisnumber;
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

	public Vehicle getVehicle() {
		return this.vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Set<Trailercapacity> getTrailercapacities() {
		return this.trailercapacities;
	}

	public void setTrailercapacities(Set<Trailercapacity> trailercapacities) {
		this.trailercapacities = trailercapacities;
	}

	public Trailercapacity addTrailercapacity(Trailercapacity trailercapacity) {
		getTrailercapacities().add(trailercapacity);
		trailercapacity.setTrailer(this);

		return trailercapacity;
	}

	public Trailercapacity removeTrailercapacity(Trailercapacity trailercapacity) {
		getTrailercapacities().remove(trailercapacity);
		trailercapacity.setTrailer(null);

		return trailercapacity;
	}

}