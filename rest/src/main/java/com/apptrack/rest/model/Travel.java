package com.apptrack.rest.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the travel database table.
 * 
 */
@Entity
@Table(name="travel")
@NamedQuery(name="Travel.findAll", query="SELECT t FROM Travel t")
public class Travel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer travelid;

	private Timestamp datearrive;

	@Column(nullable=false)
	private Timestamp datedeparture;

	//bi-directional many-to-one association to Glossary
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="state", nullable=false)
	private Glossary glossary;

	//bi-directional many-to-one association to Traveloffercandidate
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="traveloffercandidateid", nullable=false)
	private Traveloffercandidate traveloffercandidate;

	//bi-directional many-to-one association to Travelnotification
	@OneToMany(mappedBy="travel")
	private Set<Travelnotification> travelnotifications;

	//bi-directional many-to-one association to Travelpunctuation
	@OneToMany(mappedBy="travel")
	private Set<Travelpunctuation> travelpunctuations;

	//bi-directional many-to-one association to Traveltracking
	@OneToMany(mappedBy="travel")
	private Set<Traveltracking> traveltrackings;

	public Travel() {
	}

	public Integer getTravelid() {
		return this.travelid;
	}

	public void setTravelid(Integer travelid) {
		this.travelid = travelid;
	}

	public Timestamp getDatearrive() {
		return this.datearrive;
	}

	public void setDatearrive(Timestamp datearrive) {
		this.datearrive = datearrive;
	}

	public Timestamp getDatedeparture() {
		return this.datedeparture;
	}

	public void setDatedeparture(Timestamp datedeparture) {
		this.datedeparture = datedeparture;
	}

	public Glossary getGlossary() {
		return this.glossary;
	}

	public void setGlossary(Glossary glossary) {
		this.glossary = glossary;
	}

	public Traveloffercandidate getTraveloffercandidate() {
		return this.traveloffercandidate;
	}

	public void setTraveloffercandidate(Traveloffercandidate traveloffercandidate) {
		this.traveloffercandidate = traveloffercandidate;
	}

	public Set<Travelnotification> getTravelnotifications() {
		return this.travelnotifications;
	}

	public void setTravelnotifications(Set<Travelnotification> travelnotifications) {
		this.travelnotifications = travelnotifications;
	}

	public Travelnotification addTravelnotification(Travelnotification travelnotification) {
		getTravelnotifications().add(travelnotification);
		travelnotification.setTravel(this);

		return travelnotification;
	}

	public Travelnotification removeTravelnotification(Travelnotification travelnotification) {
		getTravelnotifications().remove(travelnotification);
		travelnotification.setTravel(null);

		return travelnotification;
	}

	public Set<Travelpunctuation> getTravelpunctuations() {
		return this.travelpunctuations;
	}

	public void setTravelpunctuations(Set<Travelpunctuation> travelpunctuations) {
		this.travelpunctuations = travelpunctuations;
	}

	public Travelpunctuation addTravelpunctuation(Travelpunctuation travelpunctuation) {
		getTravelpunctuations().add(travelpunctuation);
		travelpunctuation.setTravel(this);

		return travelpunctuation;
	}

	public Travelpunctuation removeTravelpunctuation(Travelpunctuation travelpunctuation) {
		getTravelpunctuations().remove(travelpunctuation);
		travelpunctuation.setTravel(null);

		return travelpunctuation;
	}

	public Set<Traveltracking> getTraveltrackings() {
		return this.traveltrackings;
	}

	public void setTraveltrackings(Set<Traveltracking> traveltrackings) {
		this.traveltrackings = traveltrackings;
	}

	public Traveltracking addTraveltracking(Traveltracking traveltracking) {
		getTraveltrackings().add(traveltracking);
		traveltracking.setTravel(this);

		return traveltracking;
	}

	public Traveltracking removeTraveltracking(Traveltracking traveltracking) {
		getTraveltrackings().remove(traveltracking);
		traveltracking.setTravel(null);

		return traveltracking;
	}

}