package com.apptrack.rest.dto;

public class ProfileDTO {
	
	private Integer profiledocumentid;
	private Integer profileid;
	private Integer glossaryid;
	private String nameProfile;
	private String nameGlosary;
	
	public Integer getProfiledocumentid() {
		return profiledocumentid;
	}
	public void setProfiledocumentid(Integer profiledocumentid) {
		this.profiledocumentid = profiledocumentid;
	}
	public Integer getProfileid() {
		return profileid;
	}
	public void setProfileid(Integer profileid) {
		this.profileid = profileid;
	}
	public Integer getGlossaryid() {
		return glossaryid;
	}
	public void setGlossaryid(Integer glossaryid) {
		this.glossaryid = glossaryid;
	}
	public String getNameProfile() {
		return nameProfile;
	}
	public void setNameProfile(String nameProfile) {
		this.nameProfile = nameProfile;
	}
	public String getNameGlosary() {
		return nameGlosary;
	}
	public void setNameGlosary(String nameGlosary) {
		this.nameGlosary = nameGlosary;
	}
	public ProfileDTO(Integer profiledocumentid, Integer profileid, Integer glossaryid, String nameProfile,
			String nameGlosary) {
		super();
		this.profiledocumentid = profiledocumentid;
		this.profileid = profileid;
		this.glossaryid = glossaryid;
		this.nameProfile = nameProfile;
		this.nameGlosary = nameGlosary;
	}
	
	public ProfileDTO() {
		
	}

	

}
