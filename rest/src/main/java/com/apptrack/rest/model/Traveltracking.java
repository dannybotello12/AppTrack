package com.apptrack.rest.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the traveltracking database table.
 * 
 */
@Entity
@Table(name="traveltracking")
@NamedQuery(name="Traveltracking.findAll", query="SELECT t FROM Traveltracking t")
public class Traveltracking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer traveltrackingid;

	@Column(nullable=false)
	private Timestamp datetracking;

	@Column(nullable=false, precision=10, scale=8)
	private BigDecimal latitude;

	@Column(nullable=false, precision=10, scale=8)
	private BigDecimal longitude;

	//bi-directional many-to-one association to Travel
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="travelid", nullable=false)
	private Travel travel;

	public Traveltracking() {
	}

	public Integer getTraveltrackingid() {
		return this.traveltrackingid;
	}

	public void setTraveltrackingid(Integer traveltrackingid) {
		this.traveltrackingid = traveltrackingid;
	}

	public Timestamp getDatetracking() {
		return this.datetracking;
	}

	public void setDatetracking(Timestamp datetracking) {
		this.datetracking = datetracking;
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

	public Travel getTravel() {
		return this.travel;
	}

	public void setTravel(Travel travel) {
		this.travel = travel;
	}

}