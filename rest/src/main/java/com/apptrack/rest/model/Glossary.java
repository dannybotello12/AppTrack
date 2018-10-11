package com.apptrack.rest.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the glossary database table.
 * 
 */
@Entity
@Table(name="glossary")
@NamedQuery(name="Glossary.findAll", query="SELECT g FROM Glossary g")
public class Glossary implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer glossaryid;

	@Column(nullable=false, length=255)
	private String name;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="categoryid")
	private Category category;
     
	//bi-directional many-to-one association to Person
	@OneToMany(mappedBy="glossary1", fetch=FetchType.LAZY )
	@JsonIgnore
	private List<Person> persons1;
	
	//bi-directional many-to-one association to Person
	@OneToMany(mappedBy="glossary2", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Person> persons2;

	//bi-directional many-to-one association to Persondocument
	@OneToMany(mappedBy="glossary", fetch=FetchType.LAZY)
	@JsonIgnore  
	private List<Persondocument> persondocuments;

	//bi-directional many-to-one association to Profiledocument
	@OneToMany(mappedBy="glossary", fetch=FetchType.LAZY)
	@JsonIgnore 
	private List<Profiledocument> profiledocuments;

	//bi-directional many-to-one association to Trailer
	@OneToMany(mappedBy="glossary1", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Trailer> trailers1;

	//bi-directional many-to-one association to Trailer
	@OneToMany(mappedBy="glossary2", fetch=FetchType.LAZY)
	@JsonIgnore  
	private List<Trailer> trailers2;

	//bi-directional many-to-one association to Trailer
	@OneToMany(mappedBy="glossary3", fetch=FetchType.LAZY)
	@JsonIgnore  
	private List<Trailer> trailers3;

	//bi-directional many-to-one association to Trailercapacity
	@OneToMany(mappedBy="glossary1", fetch=FetchType.LAZY)
	@JsonIgnore  
	private List<Trailercapacity> trailercapacities1;

	//bi-directional many-to-one association to Trailercapacity
	@OneToMany(mappedBy="glossary2", fetch=FetchType.LAZY)
	@JsonIgnore  
	private List<Trailercapacity> trailercapacities2;

	//bi-directional many-to-one association to Travel
	@OneToMany(mappedBy="glossary", fetch=FetchType.LAZY)
	@JsonIgnore  
	private List<Travel> travels;

	//bi-directional many-to-one association to Traveloffer
	@OneToMany(mappedBy="glossary1", fetch=FetchType.LAZY)
	@JsonIgnore  
	private List<Traveloffer> traveloffers1;

	//bi-directional many-to-one association to Traveloffer
	@OneToMany(mappedBy="glossary2", fetch=FetchType.LAZY)
	@JsonIgnore 
	private List<Traveloffer> traveloffers2;

	//bi-directional many-to-one association to Traveloffer
	@OneToMany(mappedBy="glossary3", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Traveloffer> traveloffers3;

	//bi-directional many-to-one association to Traveloffer
	@OneToMany(mappedBy="glossary4", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Traveloffer> traveloffers4;

	//bi-directional many-to-one association to Traveloffer
	@OneToMany(mappedBy="glossary5", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Traveloffer> traveloffers5;

	//bi-directional many-to-one association to Traveloffer
	@OneToMany(mappedBy="glossary6", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Traveloffer> traveloffers6;

	//bi-directional many-to-one association to Vehicle
	@OneToMany(mappedBy="glossary1", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Vehicle> vehicles1;

	//bi-directional many-to-one association to Vehicle
	@OneToMany(mappedBy="glossary2", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Vehicle> vehicles2;

	//bi-directional many-to-one association to Vehicle
	@OneToMany(mappedBy="glossary3", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Vehicle> vehicles3;

	//bi-directional many-to-one association to Vehicle
	@OneToMany(mappedBy="glossary4", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Vehicle> vehicles4;

	//bi-directional many-to-one association to Vehicledocument
	@OneToMany(mappedBy="glossary", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Vehicledocument> vehicledocuments;

	//bi-directional many-to-one association to Vehicleperson
	@OneToMany(mappedBy="glossary", fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Vehicleperson> vehiclepersons;

	public Glossary() {
	}

	public Integer getGlossaryid() {
		return this.glossaryid;
	}

	public void setGlossaryid(Integer glossaryid) {
		this.glossaryid = glossaryid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Person> getPersons1() {
		return this.persons1;
	}

	public void setPersons1(List<Person> persons1) {
		this.persons1 = persons1;
	}

	public Person addPersons1(Person persons1) {
		getPersons1().add(persons1);
		persons1.setGlossary1(this);

		return persons1;
	}

	public Person removePersons1(Person persons1) {
		getPersons1().remove(persons1);
		persons1.setGlossary1(null);

		return persons1;
	}

	public List<Person> getPersons2() {
		return this.persons2;
	}

	public void setPersons2(List<Person> persons2) {
		this.persons2 = persons2;
	}

	public Person addPersons2(Person persons2) {
		getPersons2().add(persons2);
		persons2.setGlossary2(this);

		return persons2;
	}

	public Person removePersons2(Person persons2) {
		getPersons2().remove(persons2);
		persons2.setGlossary2(null);

		return persons2;
	}

	public List<Persondocument> getPersondocuments() {
		return this.persondocuments;
	}

	public void setPersondocuments(List<Persondocument> persondocuments) {
		this.persondocuments = persondocuments;
	}

	public Persondocument addPersondocument(Persondocument persondocument) {
		getPersondocuments().add(persondocument);
		persondocument.setGlossary(this);

		return persondocument;
	}

	public Persondocument removePersondocument(Persondocument persondocument) {
		getPersondocuments().remove(persondocument);
		persondocument.setGlossary(null);

		return persondocument;
	}

	public List<Profiledocument> getProfiledocuments() {
		return this.profiledocuments;
	}

	public void setProfiledocuments(List<Profiledocument> profiledocuments) {
		this.profiledocuments = profiledocuments;
	}

	public Profiledocument addProfiledocument(Profiledocument profiledocument) {
		getProfiledocuments().add(profiledocument);
		profiledocument.setGlossary(this);

		return profiledocument;
	}

	public Profiledocument removeProfiledocument(Profiledocument profiledocument) {
		getProfiledocuments().remove(profiledocument);
		profiledocument.setGlossary(null);

		return profiledocument;
	}

	public List<Trailer> getTrailers1() {
		return this.trailers1;
	}

	public void setTrailers1(List<Trailer> trailers1) {
		this.trailers1 = trailers1;
	}

	public Trailer addTrailers1(Trailer trailers1) {
		getTrailers1().add(trailers1);
		trailers1.setGlossary1(this);

		return trailers1;
	}

	public Trailer removeTrailers1(Trailer trailers1) {
		getTrailers1().remove(trailers1);
		trailers1.setGlossary1(null);

		return trailers1;
	}

	public List<Trailer> getTrailers2() {
		return this.trailers2;
	}

	public void setTrailers2(List<Trailer> trailers2) {
		this.trailers2 = trailers2;
	}

	public Trailer addTrailers2(Trailer trailers2) {
		getTrailers2().add(trailers2);
		trailers2.setGlossary2(this);

		return trailers2;
	}

	public Trailer removeTrailers2(Trailer trailers2) {
		getTrailers2().remove(trailers2);
		trailers2.setGlossary2(null);

		return trailers2;
	}

	public List<Trailer> getTrailers3() {
		return this.trailers3;
	}

	public void setTrailers3(List<Trailer> trailers3) {
		this.trailers3 = trailers3;
	}

	public Trailer addTrailers3(Trailer trailers3) {
		getTrailers3().add(trailers3);
		trailers3.setGlossary3(this);

		return trailers3;
	}

	public Trailer removeTrailers3(Trailer trailers3) {
		getTrailers3().remove(trailers3);
		trailers3.setGlossary3(null);

		return trailers3;
	}

	public List<Trailercapacity> getTrailercapacities1() {
		return this.trailercapacities1;
	}

	public void setTrailercapacities1(List<Trailercapacity> trailercapacities1) {
		this.trailercapacities1 = trailercapacities1;
	}

	public Trailercapacity addTrailercapacities1(Trailercapacity trailercapacities1) {
		getTrailercapacities1().add(trailercapacities1);
		trailercapacities1.setGlossary1(this);

		return trailercapacities1;
	}

	public Trailercapacity removeTrailercapacities1(Trailercapacity trailercapacities1) {
		getTrailercapacities1().remove(trailercapacities1);
		trailercapacities1.setGlossary1(null);

		return trailercapacities1;
	}

	public List<Trailercapacity> getTrailercapacities2() {
		return this.trailercapacities2;
	}

	public void setTrailercapacities2(List<Trailercapacity> trailercapacities2) {
		this.trailercapacities2 = trailercapacities2;
	}

	public Trailercapacity addTrailercapacities2(Trailercapacity trailercapacities2) {
		getTrailercapacities2().add(trailercapacities2);
		trailercapacities2.setGlossary2(this);

		return trailercapacities2;
	}

	public Trailercapacity removeTrailercapacities2(Trailercapacity trailercapacities2) {
		getTrailercapacities2().remove(trailercapacities2);
		trailercapacities2.setGlossary2(null);

		return trailercapacities2;
	}

	public List<Travel> getTravels() {
		return this.travels;
	}

	public void setTravels(List<Travel> travels) {
		this.travels = travels;
	}

	public Travel addTravel(Travel travel) {
		getTravels().add(travel);
		travel.setGlossary(this);

		return travel;
	}

	public Travel removeTravel(Travel travel) {
		getTravels().remove(travel);
		travel.setGlossary(null);

		return travel;
	}

	public List<Traveloffer> getTraveloffers1() {
		return this.traveloffers1;
	}

	public void setTraveloffers1(List<Traveloffer> traveloffers1) {
		this.traveloffers1 = traveloffers1;
	}

	public Traveloffer addTraveloffers1(Traveloffer traveloffers1) {
		getTraveloffers1().add(traveloffers1);
		traveloffers1.setGlossary1(this);

		return traveloffers1;
	}

	public Traveloffer removeTraveloffers1(Traveloffer traveloffers1) {
		getTraveloffers1().remove(traveloffers1);
		traveloffers1.setGlossary1(null);

		return traveloffers1;
	}

	public List<Traveloffer> getTraveloffers2() {
		return this.traveloffers2;
	}

	public void setTraveloffers2(List<Traveloffer> traveloffers2) {
		this.traveloffers2 = traveloffers2;
	}

	public Traveloffer addTraveloffers2(Traveloffer traveloffers2) {
		getTraveloffers2().add(traveloffers2);
		traveloffers2.setGlossary2(this);

		return traveloffers2;
	}

	public Traveloffer removeTraveloffers2(Traveloffer traveloffers2) {
		getTraveloffers2().remove(traveloffers2);
		traveloffers2.setGlossary2(null);

		return traveloffers2;
	}

	public List<Traveloffer> getTraveloffers3() {
		return this.traveloffers3;
	}

	public void setTraveloffers3(List<Traveloffer> traveloffers3) {
		this.traveloffers3 = traveloffers3;
	}

	public Traveloffer addTraveloffers3(Traveloffer traveloffers3) {
		getTraveloffers3().add(traveloffers3);
		traveloffers3.setGlossary3(this);

		return traveloffers3;
	}

	public Traveloffer removeTraveloffers3(Traveloffer traveloffers3) {
		getTraveloffers3().remove(traveloffers3);
		traveloffers3.setGlossary3(null);

		return traveloffers3;
	}

	public List<Traveloffer> getTraveloffers4() {
		return this.traveloffers4;
	}

	public void setTraveloffers4(List<Traveloffer> traveloffers4) {
		this.traveloffers4 = traveloffers4;
	}

	public Traveloffer addTraveloffers4(Traveloffer traveloffers4) {
		getTraveloffers4().add(traveloffers4);
		traveloffers4.setGlossary4(this);

		return traveloffers4;
	}

	public Traveloffer removeTraveloffers4(Traveloffer traveloffers4) {
		getTraveloffers4().remove(traveloffers4);
		traveloffers4.setGlossary4(null);

		return traveloffers4;
	}

	public List<Traveloffer> getTraveloffers5() {
		return this.traveloffers5;
	}

	public void setTraveloffers5(List<Traveloffer> traveloffers5) {
		this.traveloffers5 = traveloffers5;
	}

	public Traveloffer addTraveloffers5(Traveloffer traveloffers5) {
		getTraveloffers5().add(traveloffers5);
		traveloffers5.setGlossary5(this);

		return traveloffers5;
	}

	public Traveloffer removeTraveloffers5(Traveloffer traveloffers5) {
		getTraveloffers5().remove(traveloffers5);
		traveloffers5.setGlossary5(null);

		return traveloffers5;
	}

	public List<Traveloffer> getTraveloffers6() {
		return this.traveloffers6;
	}

	public void setTraveloffers6(List<Traveloffer> traveloffers6) {
		this.traveloffers6 = traveloffers6;
	}

	public Traveloffer addTraveloffers6(Traveloffer traveloffers6) {
		getTraveloffers6().add(traveloffers6);
		traveloffers6.setGlossary6(this);

		return traveloffers6;
	}

	public Traveloffer removeTraveloffers6(Traveloffer traveloffers6) {
		getTraveloffers6().remove(traveloffers6);
		traveloffers6.setGlossary6(null);

		return traveloffers6;
	}

	public List<Vehicle> getVehicles1() {
		return this.vehicles1;
	}

	public void setVehicles1(List<Vehicle> vehicles1) {
		this.vehicles1 = vehicles1;
	}

	public Vehicle addVehicles1(Vehicle vehicles1) {
		getVehicles1().add(vehicles1);
		vehicles1.setGlossary1(this);

		return vehicles1;
	}

	public Vehicle removeVehicles1(Vehicle vehicles1) {
		getVehicles1().remove(vehicles1);
		vehicles1.setGlossary1(null);

		return vehicles1;
	}

	public List<Vehicle> getVehicles2() {
		return this.vehicles2;
	}

	public void setVehicles2(List<Vehicle> vehicles2) {
		this.vehicles2 = vehicles2;
	}

	public Vehicle addVehicles2(Vehicle vehicles2) {
		getVehicles2().add(vehicles2);
		vehicles2.setGlossary2(this);

		return vehicles2;
	}

	public Vehicle removeVehicles2(Vehicle vehicles2) {
		getVehicles2().remove(vehicles2);
		vehicles2.setGlossary2(null);

		return vehicles2;
	}

	public List<Vehicle> getVehicles3() {
		return this.vehicles3;
	}

	public void setVehicles3(List<Vehicle> vehicles3) {
		this.vehicles3 = vehicles3;
	}

	public Vehicle addVehicles3(Vehicle vehicles3) {
		getVehicles3().add(vehicles3);
		vehicles3.setGlossary3(this);

		return vehicles3;
	}

	public Vehicle removeVehicles3(Vehicle vehicles3) {
		getVehicles3().remove(vehicles3);
		vehicles3.setGlossary3(null);

		return vehicles3;
	}

	public List<Vehicle> getVehicles4() {
		return this.vehicles4;
	}

	public void setVehicles4(List<Vehicle> vehicles4) {
		this.vehicles4 = vehicles4;
	}

	public Vehicle addVehicles4(Vehicle vehicles4) {
		getVehicles4().add(vehicles4);
		vehicles4.setGlossary4(this);

		return vehicles4;
	}

	public Vehicle removeVehicles4(Vehicle vehicles4) {
		getVehicles4().remove(vehicles4);
		vehicles4.setGlossary4(null);

		return vehicles4;
	}

	public List<Vehicledocument> getVehicledocuments() {
		return this.vehicledocuments;
	}

	public void setVehicledocuments(List<Vehicledocument> vehicledocuments) {
		this.vehicledocuments = vehicledocuments;
	}

	public Vehicledocument addVehicledocument(Vehicledocument vehicledocument) {
		getVehicledocuments().add(vehicledocument);
		vehicledocument.setGlossary(this);

		return vehicledocument;
	}

	public Vehicledocument removeVehicledocument(Vehicledocument vehicledocument) {
		getVehicledocuments().remove(vehicledocument);
		vehicledocument.setGlossary(null);

		return vehicledocument;
	}

	public List<Vehicleperson> getVehiclepersons() {
		return this.vehiclepersons;
	}

	public void setVehiclepersons(List<Vehicleperson> vehiclepersons) {
		this.vehiclepersons = vehiclepersons;
	}

	public Vehicleperson addVehicleperson(Vehicleperson vehicleperson) {
		getVehiclepersons().add(vehicleperson);
		vehicleperson.setGlossary(this);

		return vehicleperson;
	}

	public Vehicleperson removeVehicleperson(Vehicleperson vehicleperson) {
		getVehiclepersons().remove(vehicleperson);
		vehicleperson.setGlossary(null);

		return vehicleperson;
	}

}