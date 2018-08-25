package com.apptrack.rest.dto;

public class PersonaDTO {
	
	

	private String address;

	private String cellphone;

	private Integer city;

	private String email;

	private String lastnames;

	private String names;

	private String numberid;

	private String password;

	private String telephone;
	
	private Integer state;
	
	private Integer typedocument;
	
	public Integer getState() {
		return state;
	}



	public void setState(Integer state) {
		this.state = state;
	}



	public Integer getTypedocument() {
		return typedocument;
	}



	public void setTypedocument(Integer typedocument) {
		this.typedocument = typedocument;
	}



	
	
	
	
	

	public PersonaDTO( String address, String cellphone, Integer city, String email, String lastnames,
			String names, String numberid, String password, String telephone) {
		super();
	
		this.address = address;
		this.cellphone = cellphone;
		this.city = city;
		this.email = email;
		this.lastnames = lastnames;
		this.names = names;
		this.numberid = numberid;
		this.password = password;
		this.telephone = telephone;
	}
	
	

	public PersonaDTO() {
		super();
	}





	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public Integer getCity() {
		return city;
	}

	public void setCity(Integer city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastnames() {
		return lastnames;
	}

	public void setLastnames(String lastnames) {
		this.lastnames = lastnames;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getNumberid() {
		return numberid;
	}

	public void setNumberid(String numberid) {
		this.numberid = numberid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}






	


}
