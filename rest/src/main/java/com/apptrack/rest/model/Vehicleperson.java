package com.apptrack.rest.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the vehicleperson database table.
 * 
 */
@Entity
@Table(name="vehicleperson")
@NamedQuery(name="Vehicleperson.findAll", query="SELECT v FROM Vehicleperson v")
public class Vehicleperson implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer vehiclepersonid;

	@Column(nullable=false)
	private Timestamp datefrom;

	private Timestamp dateuntil;

	//bi-directional many-to-one association to Glossary
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="state", nullable=false)
	private Glossary glossary;

	//bi-directional many-to-one association to Person
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="personid", nullable=false)
	private Person person;

	//bi-directional many-to-one association to Vehicle
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="vehicleid", nullable=false)
	private Vehicle vehicle;

	public Vehicleperson() {
	}

	public Integer getVehiclepersonid() {
		return this.vehiclepersonid;
	}

	public void setVehiclepersonid(Integer vehiclepersonid) {
		this.vehiclepersonid = vehiclepersonid;
	}

	public Timestamp getDatefrom() {
		return this.datefrom;
	}

	public void setDatefrom(Timestamp datefrom) {
		this.datefrom = datefrom;
	}

	public Timestamp getDateuntil() {
		return this.dateuntil;
	}

	public void setDateuntil(Timestamp dateuntil) {
		this.dateuntil = dateuntil;
	}

	public Glossary getGlossary() {
		return this.glossary;
	}

	public void setGlossary(Glossary glossary) {
		this.glossary = glossary;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Vehicle getVehicle() {
		return this.vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

}