package com.apptrack.rest.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the traveloffer database table.
 * 
 */
@Entity
@Table(name="traveloffer")
@NamedQuery(name="Traveloffer.findAll", query="SELECT t FROM Traveloffer t")
public class Traveloffer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer travelofferid;

	@Column(nullable=false)
	private Timestamp assignementdate;

	@Column(length=250)
	private String chargeobservation;

	@Column(nullable=false)
	private Timestamp offerdate;

	@Column(nullable=false, length=250)
	private String product;

	@Column(nullable=false, precision=10, scale=2)
	private BigDecimal weight;

	//bi-directional many-to-one association to Glossary
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="chargenature", nullable=false)
	private Glossary glossary1;

	//bi-directional many-to-one association to Glossary
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="chargetype", nullable=false)
	private Glossary glossary2;

	//bi-directional many-to-one association to Glossary
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="naturalstate", nullable=false)
	private Glossary glossary3;

	//bi-directional many-to-one association to Glossary
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="packingtype")
	private Glossary glossary4;

	//bi-directional many-to-one association to Glossary
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="state", nullable=false)
	private Glossary glossary5;

	//bi-directional many-to-one association to Glossary
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="unit", nullable=false)
	private Glossary glossary6;

	//bi-directional many-to-one association to Person
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="personid", nullable=false)
	private Person person;

	//bi-directional many-to-one association to Traveloffercandidate
	@OneToMany(mappedBy="traveloffer")
	private Set<Traveloffercandidate> traveloffercandidates;

	public Traveloffer() {
	}

	public Integer getTravelofferid() {
		return this.travelofferid;
	}

	public void setTravelofferid(Integer travelofferid) {
		this.travelofferid = travelofferid;
	}

	public Timestamp getAssignementdate() {
		return this.assignementdate;
	}

	public void setAssignementdate(Timestamp assignementdate) {
		this.assignementdate = assignementdate;
	}

	public String getChargeobservation() {
		return this.chargeobservation;
	}

	public void setChargeobservation(String chargeobservation) {
		this.chargeobservation = chargeobservation;
	}

	public Timestamp getOfferdate() {
		return this.offerdate;
	}

	public void setOfferdate(Timestamp offerdate) {
		this.offerdate = offerdate;
	}

	public String getProduct() {
		return this.product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public BigDecimal getWeight() {
		return this.weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
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

	public Glossary getGlossary5() {
		return this.glossary5;
	}

	public void setGlossary5(Glossary glossary5) {
		this.glossary5 = glossary5;
	}

	public Glossary getGlossary6() {
		return this.glossary6;
	}

	public void setGlossary6(Glossary glossary6) {
		this.glossary6 = glossary6;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Set<Traveloffercandidate> getTraveloffercandidates() {
		return this.traveloffercandidates;
	}

	public void setTraveloffercandidates(Set<Traveloffercandidate> traveloffercandidates) {
		this.traveloffercandidates = traveloffercandidates;
	}

	public Traveloffercandidate addTraveloffercandidate(Traveloffercandidate traveloffercandidate) {
		getTraveloffercandidates().add(traveloffercandidate);
		traveloffercandidate.setTraveloffer(this);

		return traveloffercandidate;
	}

	public Traveloffercandidate removeTraveloffercandidate(Traveloffercandidate traveloffercandidate) {
		getTraveloffercandidates().remove(traveloffercandidate);
		traveloffercandidate.setTraveloffer(null);

		return traveloffercandidate;
	}

}