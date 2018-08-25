package com.apptrack.rest.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the trailercapacity database table.
 * 
 */
@Entity
@Table(name="trailercapacity")
@NamedQuery(name="Trailercapacity.findAll", query="SELECT t FROM Trailercapacity t")
public class Trailercapacity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer trailercapacityid;

	@Column(nullable=false, precision=10, scale=2)
	private BigDecimal capacity;

	//bi-directional many-to-one association to Glossary
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="designpbv", nullable=false)
	private Glossary glossary1;

	//bi-directional many-to-one association to Glossary
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="unit", nullable=false)
	private Glossary glossary2;

	//bi-directional many-to-one association to Trailer
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="trailerid")
	private Trailer trailer;

	public Trailercapacity() {
	}

	public Integer getTrailercapacityid() {
		return this.trailercapacityid;
	}

	public void setTrailercapacityid(Integer trailercapacityid) {
		this.trailercapacityid = trailercapacityid;
	}

	public BigDecimal getCapacity() {
		return this.capacity;
	}

	public void setCapacity(BigDecimal capacity) {
		this.capacity = capacity;
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

	public Trailer getTrailer() {
		return this.trailer;
	}

	public void setTrailer(Trailer trailer) {
		this.trailer = trailer;
	}

}