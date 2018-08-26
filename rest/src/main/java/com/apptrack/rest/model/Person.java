package com.apptrack.rest.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the person database table.
 * 
 */
@Entity
@Table(name="person")
@NamedQuery(name="Person.findAll", query="SELECT p FROM Person p")
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	 @SequenceGenerator(name="person_seq",
     sequenceName="person_seq",
     allocationSize=1)
	 @GeneratedValue(strategy = GenerationType.SEQUENCE,
     generator="person_seq")
	@Column(unique=true, nullable=false)
	private Integer personid;

	@Column(length=2147483647)
	private String address;

	@Column(nullable=false, length=15)
	private String cellphone;

	private Integer city;

	@Column(nullable=false, length=100)
	private String email;

	@Column(length=100)
	private String lastnames;

	@Column(nullable=false, length=100)
	private String names;

	@Column(nullable=false, length=15)
	private String numberid;

	@Column(nullable=false, length=50)
	private String password;

	@Column(length=15)
	private String telephone;

	//bi-directional many-to-one association to Glossary
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="state")
	@JsonIgnore
	private Glossary glossary1;

	//bi-directional many-to-one association to Glossary
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="typedocument", nullable=false)
	@JsonIgnore
	private Glossary glossary2;

	//bi-directional many-to-one association to Persondocument
	@OneToMany(mappedBy="person")
	private Set<Persondocument> persondocuments;

	//bi-directional many-to-one association to Personimage
	@OneToMany(mappedBy="person")
	private Set<Personimage> personimages;

	//bi-directional many-to-one association to Personprofile
	@OneToMany(mappedBy="person")
	private Set<Personprofile> personprofiles;

	//bi-directional many-to-one association to Traveloffer
	@OneToMany(mappedBy="person")
	private Set<Traveloffer> traveloffers;

	//bi-directional many-to-one association to Travelpunctuation
	@OneToMany(mappedBy="person")
	private Set<Travelpunctuation> travelpunctuations;

	//bi-directional many-to-one association to Vehicleperson
	@OneToMany(mappedBy="person")
	private Set<Vehicleperson> vehiclepersons;
	
	@Transient
	private Integer state;
	
	@Transient
	private Integer typedocument;
	

	public Integer getTypedocument() {
		return glossary2.getGlossaryid();
	}

	public Person() {
	}

	public Integer getPersonid() {
		return this.personid;
	}

	public void setPersonid(Integer personid) {
		this.personid = personid;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCellphone() {
		return this.cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public Integer getCity() {
		return this.city;
	}

	public void setCity(Integer city) {
		this.city = city;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastnames() {
		return this.lastnames;
	}

	public void setLastnames(String lastnames) {
		this.lastnames = lastnames;
	}

	public String getNames() {
		return this.names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getNumberid() {
		return this.numberid;
	}

	public void setNumberid(String numberid) {
		this.numberid = numberid;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Glossary getGlossary1() {
		return this.glossary1;
	}

	public void setGlossary1(Glossary glossary1) {
		this.glossary1 = glossary1;
	}

	public Glossary getGlossary2() {
		return this.glossary2;
	}

	public void setGlossary2(Glossary glossary2) {
		this.glossary2 = glossary2;
	}

	public Set<Persondocument> getPersondocuments() {
		return this.persondocuments;
	}

	public void setPersondocuments(Set<Persondocument> persondocuments) {
		this.persondocuments = persondocuments;
	}

	public Persondocument addPersondocument(Persondocument persondocument) {
		getPersondocuments().add(persondocument);
		persondocument.setPerson(this);

		return persondocument;
	}

	public Persondocument removePersondocument(Persondocument persondocument) {
		getPersondocuments().remove(persondocument);
		persondocument.setPerson(null);

		return persondocument;
	}

	public Set<Personimage> getPersonimages() {
		return this.personimages;
	}

	public void setPersonimages(Set<Personimage> personimages) {
		this.personimages = personimages;
	}

	public Personimage addPersonimage(Personimage personimage) {
		getPersonimages().add(personimage);
		personimage.setPerson(this);

		return personimage;
	}

	public Personimage removePersonimage(Personimage personimage) {
		getPersonimages().remove(personimage);
		personimage.setPerson(null);

		return personimage;
	}

	public Set<Personprofile> getPersonprofiles() {
		return this.personprofiles;
	}

	public void setPersonprofiles(Set<Personprofile> personprofiles) {
		this.personprofiles = personprofiles;
	}

	public Personprofile addPersonprofile(Personprofile personprofile) {
		getPersonprofiles().add(personprofile);
		personprofile.setPerson(this);

		return personprofile;
	}

	public Personprofile removePersonprofile(Personprofile personprofile) {
		getPersonprofiles().remove(personprofile);
		personprofile.setPerson(null);

		return personprofile;
	}

	public Set<Traveloffer> getTraveloffers() {
		return this.traveloffers;
	}

	public void setTraveloffers(Set<Traveloffer> traveloffers) {
		this.traveloffers = traveloffers;
	}

	public Traveloffer addTraveloffer(Traveloffer traveloffer) {
		getTraveloffers().add(traveloffer);
		traveloffer.setPerson(this);

		return traveloffer;
	}

	public Traveloffer removeTraveloffer(Traveloffer traveloffer) {
		getTraveloffers().remove(traveloffer);
		traveloffer.setPerson(null);

		return traveloffer;
	}

	public Set<Travelpunctuation> getTravelpunctuations() {
		return this.travelpunctuations;
	}

	public void setTravelpunctuations(Set<Travelpunctuation> travelpunctuations) {
		this.travelpunctuations = travelpunctuations;
	}

	public Travelpunctuation addTravelpunctuation(Travelpunctuation travelpunctuation) {
		getTravelpunctuations().add(travelpunctuation);
		travelpunctuation.setPerson(this);

		return travelpunctuation;
	}

	public Travelpunctuation removeTravelpunctuation(Travelpunctuation travelpunctuation) {
		getTravelpunctuations().remove(travelpunctuation);
		travelpunctuation.setPerson(null);

		return travelpunctuation;
	}

	public Set<Vehicleperson> getVehiclepersons() {
		return this.vehiclepersons;
	}

	public void setVehiclepersons(Set<Vehicleperson> vehiclepersons) {
		this.vehiclepersons = vehiclepersons;
	}

	public Vehicleperson addVehicleperson(Vehicleperson vehicleperson) {
		getVehiclepersons().add(vehicleperson);
		vehicleperson.setPerson(this);

		return vehicleperson;
	}

	public Vehicleperson removeVehicleperson(Vehicleperson vehicleperson) {
		getVehiclepersons().remove(vehicleperson);
		vehicleperson.setPerson(null);

		return vehicleperson;
	}

	public Integer getState() {
		return getGlossary1().getGlossaryid();
	}

	

}