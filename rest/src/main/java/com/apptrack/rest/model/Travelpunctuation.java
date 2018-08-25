package com.apptrack.rest.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the travelpunctuation database table.
 * 
 */
@Entity
@Table(name="travelpunctuation")
@NamedQuery(name="Travelpunctuation.findAll", query="SELECT t FROM Travelpunctuation t")
public class Travelpunctuation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer travelpunctuationid;

	@Column(nullable=false)
	private Integer punctuation;

	//bi-directional many-to-one association to Person
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="personid", nullable=false)
	private Person person;

	//bi-directional many-to-one association to Travel
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="travelid", nullable=false)
	private Travel travel;

	public Travelpunctuation() {
	}

	public Integer getTravelpunctuationid() {
		return this.travelpunctuationid;
	}

	public void setTravelpunctuationid(Integer travelpunctuationid) {
		this.travelpunctuationid = travelpunctuationid;
	}

	public Integer getPunctuation() {
		return this.punctuation;
	}

	public void setPunctuation(Integer punctuation) {
		this.punctuation = punctuation;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Travel getTravel() {
		return this.travel;
	}

	public void setTravel(Travel travel) {
		this.travel = travel;
	}

}