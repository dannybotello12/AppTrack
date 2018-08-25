package com.apptrack.rest.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the travelnotification database table.
 * 
 */
@Entity
@Table(name="travelnotification")
@NamedQuery(name="Travelnotification.findAll", query="SELECT t FROM Travelnotification t")
public class Travelnotification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer travelnotificationid;

	@Column(nullable=false)
	private Timestamp datenotification;

	@Column(nullable=false, precision=10, scale=8)
	private BigDecimal latitude;

	@Column(nullable=false, precision=10, scale=8)
	private BigDecimal longitude;

	@Column(nullable=false, length=250)
	private String observation;

	//bi-directional many-to-one association to Travel
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="travelid", nullable=false)
	private Travel travel;

	public Travelnotification() {
	}

	public Integer getTravelnotificationid() {
		return this.travelnotificationid;
	}

	public void setTravelnotificationid(Integer travelnotificationid) {
		this.travelnotificationid = travelnotificationid;
	}

	public Timestamp getDatenotification() {
		return this.datenotification;
	}

	public void setDatenotification(Timestamp datenotification) {
		this.datenotification = datenotification;
	}

	public BigDecimal getLatitude() {
		return this.latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return this.longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public String getObservation() {
		return this.observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Travel getTravel() {
		return this.travel;
	}

	public void setTravel(Travel travel) {
		this.travel = travel;
	}

}