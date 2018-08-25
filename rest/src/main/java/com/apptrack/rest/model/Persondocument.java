package com.apptrack.rest.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the persondocument database table.
 * 
 */
@Entity
@Table(name="persondocument")
@NamedQuery(name="Persondocument.findAll", query="SELECT p FROM Persondocument p")
public class Persondocument implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer persondocumentid;

	@Column(nullable=false)
	private byte[] image;

	//bi-directional many-to-one association to Glossary
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="slide", nullable=false)
	private Glossary glossary;

	//bi-directional many-to-one association to Person
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="personid", nullable=false)
	private Person person;

	//bi-directional many-to-one association to Profiledocument
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="profiledocumentid", nullable=false)
	private Profiledocument profiledocument;

	public Persondocument() {
	}

	public Integer getPersondocumentid() {
		return this.persondocumentid;
	}

	public void setPersondocumentid(Integer persondocumentid) {
		this.persondocumentid = persondocumentid;
	}

	public byte[] getImage() {
		return this.image;
	}

	public void setImage(byte[] image) {
		this.image = image;
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

	public Profiledocument getProfiledocument() {
		return this.profiledocument;
	}

	public void setProfiledocument(Profiledocument profiledocument) {
		this.profiledocument = profiledocument;
	}

}