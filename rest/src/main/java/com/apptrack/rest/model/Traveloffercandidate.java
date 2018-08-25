package com.apptrack.rest.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the traveloffercandidate database table.
 * 
 */
@Entity
@Table(name="traveloffercandidate")
@NamedQuery(name="Traveloffercandidate.findAll", query="SELECT t FROM Traveloffercandidate t")
public class Traveloffercandidate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer traveloffercandidateid;

	private Boolean accept;

	private Timestamp acceptdate;

	private Boolean selected;

	private Timestamp selecteddate;

	//bi-directional many-to-one association to Travel
	@OneToMany(mappedBy="traveloffercandidate")
	private Set<Travel> travels;

	//bi-directional many-to-one association to Traveloffer
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="travelofferid", nullable=false)
	private Traveloffer traveloffer;

	//bi-directional many-to-one association to Vehicle
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="vehicleid", nullable=false)
	private Vehicle vehicle;

	public Traveloffercandidate() {
	}

	public Integer getTraveloffercandidateid() {
		return this.traveloffercandidateid;
	}

	public void setTraveloffercandidateid(Integer traveloffercandidateid) {
		this.traveloffercandidateid = traveloffercandidateid;
	}

	public Boolean getAccept() {
		return this.accept;
	}

	public void setAccept(Boolean accept) {
		this.accept = accept;
	}

	public Timestamp getAcceptdate() {
		return this.acceptdate;
	}

	public void setAcceptdate(Timestamp acceptdate) {
		this.acceptdate = acceptdate;
	}

	public Boolean getSelected() {
		return this.selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

	public Timestamp getSelecteddate() {
		return this.selecteddate;
	}

	public void setSelecteddate(Timestamp selecteddate) {
		this.selecteddate = selecteddate;
	}

	public Set<Travel> getTravels() {
		return this.travels;
	}

	public void setTravels(Set<Travel> travels) {
		this.travels = travels;
	}

	public Travel addTravel(Travel travel) {
		getTravels().add(travel);
		travel.setTraveloffercandidate(this);

		return travel;
	}

	public Travel removeTravel(Travel travel) {
		getTravels().remove(travel);
		travel.setTraveloffercandidate(null);

		return travel;
	}

	public Traveloffer getTraveloffer() {
		return this.traveloffer;
	}

	public void setTraveloffer(Traveloffer traveloffer) {
		this.traveloffer = traveloffer;
	}

	public Vehicle getVehicle() {
		return this.vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

}