package com.apptrack.rest.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the personprofile database table.
 * 
 */
@Entity
@Table(name="personprofile")
@NamedQuery(name="Personprofile.findAll", query="SELECT p FROM Personprofile p")
public class Personprofile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer personprofileid;

	//bi-directional many-to-one association to Person
	@ManyToOne
	@JoinColumn(name="personid", nullable=false)
	private Person person;

	//bi-directional many-to-one association to Profile
	@ManyToOne
	@JoinColumn(name="profileid", nullable=false)
	private Profile profile;

	public Personprofile() {
	}

	public Integer getPersonprofileid() {
		return this.personprofileid;
	}

	public void setPersonprofileid(Integer personprofileid) {
		this.personprofileid = personprofileid;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Profile getProfile() {
		return this.profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

}