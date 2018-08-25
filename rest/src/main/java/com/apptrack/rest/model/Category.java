package com.apptrack.rest.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@Table(name="category")
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer categoryid;

	@Column(nullable=false, length=100)
	private String name;

	//bi-directional many-to-one association to Glossary
	@OneToMany(mappedBy="category")
	private Set<Glossary> glossaries;

	//bi-directional many-to-one association to Profile
	@OneToMany(mappedBy="category")
	private Set<Profile> profiles;

	public Category() {
	}

	public Integer getCategoryid() {
		return this.categoryid;
	}

	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Glossary> getGlossaries() {
		return this.glossaries;
	}

	public void setGlossaries(Set<Glossary> glossaries) {
		this.glossaries = glossaries;
	}

	public Glossary addGlossary(Glossary glossary) {
		getGlossaries().add(glossary);
		glossary.setCategory(this);

		return glossary;
	}

	public Glossary removeGlossary(Glossary glossary) {
		getGlossaries().remove(glossary);
		glossary.setCategory(null);

		return glossary;
	}

	public Set<Profile> getProfiles() {
		return this.profiles;
	}

	public void setProfiles(Set<Profile> profiles) {
		this.profiles = profiles;
	}

	public Profile addProfile(Profile profile) {
		getProfiles().add(profile);
		profile.setCategory(this);

		return profile;
	}

	public Profile removeProfile(Profile profile) {
		getProfiles().remove(profile);
		profile.setCategory(null);

		return profile;
	}

}