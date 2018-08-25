package com.apptrack.rest.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the personimage database table.
 * 
 */
@Entity
@Table(name="personimage")
@NamedQuery(name="Personimage.findAll", query="SELECT p FROM Personimage p")
public class Personimage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer personimageid;

	private byte[] image;

	//bi-directional many-to-one association to Person
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="personid")
	private Person person;

	public Personimage() {
	}

	public Integer getPersonimageid() {
		return this.personimageid;
	}

	public void setPersonimageid(Integer personimageid) {
		this.personimageid = personimageid;
	}

	public byte[] getImage() {
		return this.image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}