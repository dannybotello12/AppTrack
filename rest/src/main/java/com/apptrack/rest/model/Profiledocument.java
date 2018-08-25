package com.apptrack.rest.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the profiledocument database table.
 * 
 */
@Entity
@Table(name="profiledocument")
@NamedQuery(name="Profiledocument.findAll", query="SELECT p FROM Profiledocument p")
public class Profiledocument implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer profiledocumentid;

	//bi-directional many-to-one association to Persondocument
	@OneToMany(mappedBy="profiledocument")
	private Set<Persondocument> persondocuments;

	//bi-directional many-to-one association to Glossary
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="glossaryid")
	private Glossary glossary;

	//bi-directional many-to-one association to Profile
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="profileid")
	private Profile profile;

	//bi-directional many-to-one association to Vehicledocument
	@OneToMany(mappedBy="profiledocument")
	private Set<Vehicledocument> vehicledocuments;

	public Profiledocument() {
	}

	public Integer getProfiledocumentid() {
		return this.profiledocumentid;
	}

	public void setProfiledocumentid(Integer profiledocumentid) {
		this.profiledocumentid = profiledocumentid;
	}

	public Set<Persondocument> getPersondocuments() {
		return this.persondocuments;
	}

	public void setPersondocuments(Set<Persondocument> persondocuments) {
		this.persondocuments = persondocuments;
	}

	public Persondocument addPersondocument(Persondocument persondocument) {
		getPersondocuments().add(persondocument);
		persondocument.setProfiledocument(this);

		return persondocument;
	}

	public Persondocument removePersondocument(Persondocument persondocument) {
		getPersondocuments().remove(persondocument);
		persondocument.setProfiledocument(null);

		return persondocument;
	}

	public Glossary getGlossary() {
		return this.glossary;
	}

	public void setGlossary(Glossary glossary) {
		this.glossary = glossary;
	}

	public Profile getProfile() {
		return this.profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Set<Vehicledocument> getVehicledocuments() {
		return this.vehicledocuments;
	}

	public void setVehicledocuments(Set<Vehicledocument> vehicledocuments) {
		this.vehicledocuments = vehicledocuments;
	}

	public Vehicledocument addVehicledocument(Vehicledocument vehicledocument) {
		getVehicledocuments().add(vehicledocument);
		vehicledocument.setProfiledocument(this);

		return vehicledocument;
	}

	public Vehicledocument removeVehicledocument(Vehicledocument vehicledocument) {
		getVehicledocuments().remove(vehicledocument);
		vehicledocument.setProfiledocument(null);

		return vehicledocument;
	}

}