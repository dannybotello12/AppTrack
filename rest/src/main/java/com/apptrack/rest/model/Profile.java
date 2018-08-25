package com.apptrack.rest.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the profile database table.
 * 
 */
@Entity
@Table(name="profile")
@NamedQuery(name="Profile.findAll", query="SELECT p FROM Profile p")
public class Profile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer profileid;

	@Column(nullable=false, length=50)
	private String name;

	private Integer state;

	//bi-directional many-to-one association to Personprofile
	@OneToMany(mappedBy="profile")
	private Set<Personprofile> personprofiles;

	//bi-directional many-to-one association to Category
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="categoryid", nullable=false)
	private Category category;

	//bi-directional many-to-one association to Profiledocument
	@OneToMany(mappedBy="profile")
	private Set<Profiledocument> profiledocuments;

	public Profile() {
	}

	public Integer getProfileid() {
		return this.profileid;
	}

	public void setProfileid(Integer profileid) {
		this.profileid = profileid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Set<Personprofile> getPersonprofiles() {
		return this.personprofiles;
	}

	public void setPersonprofiles(Set<Personprofile> personprofiles) {
		this.personprofiles = personprofiles;
	}

	public Personprofile addPersonprofile(Personprofile personprofile) {
		getPersonprofiles().add(personprofile);
		personprofile.setProfile(this);

		return personprofile;
	}

	public Personprofile removePersonprofile(Personprofile personprofile) {
		getPersonprofiles().remove(personprofile);
		personprofile.setProfile(null);

		return personprofile;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Profiledocument> getProfiledocuments() {
		return this.profiledocuments;
	}

	public void setProfiledocuments(Set<Profiledocument> profiledocuments) {
		this.profiledocuments = profiledocuments;
	}

	public Profiledocument addProfiledocument(Profiledocument profiledocument) {
		getProfiledocuments().add(profiledocument);
		profiledocument.setProfile(this);

		return profiledocument;
	}

	public Profiledocument removeProfiledocument(Profiledocument profiledocument) {
		getProfiledocuments().remove(profiledocument);
		profiledocument.setProfile(null);

		return profiledocument;
	}

}