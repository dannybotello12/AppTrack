package com.apptrack.rest.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the vehicleimage database table.
 * 
 */
@Entity
@Table(name="vehicleimage")
@NamedQuery(name="Vehicleimage.findAll", query="SELECT v FROM Vehicleimage v")
public class Vehicleimage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer vehicleimageid;

	private byte[] image;

	//bi-directional many-to-one association to Vehicle
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="vehicleid", nullable=false)
	private Vehicle vehicle;

	public Vehicleimage() {
	}

	public Integer getVehicleimageid() {
		return this.vehicleimageid;
	}

	public void setVehicleimageid(Integer vehicleimageid) {
		this.vehicleimageid = vehicleimageid;
	}

	public byte[] getImage() {
		return this.image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Vehicle getVehicle() {
		return this.vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

}