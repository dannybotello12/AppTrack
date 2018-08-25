package com.apptrack.rest.util;

import com.apptrack.rest.dto.PersonaDTO;
import com.apptrack.rest.model.Glossary;
import com.apptrack.rest.model.Person;

public class Convertidor {
	
	
	public Person personaDTOtoPerson(PersonaDTO person)
	{
		
		Person persona= new Person();
		Glossary state=new Glossary();
		Glossary typedocument=new Glossary();
		
		persona.setAddress(person.getAddress());
		persona.setCellphone(person.getCellphone());
		persona.setCity(person.getCity());
		persona.setEmail(person.getEmail());
		persona.setLastnames(person.getLastnames());
		persona.setNames(person.getNames());
		persona.setNumberid(person.getNumberid());
		persona.setPassword(person.getPassword());
		state.setGlossaryid(person.getState());
		persona.setGlossary1(state);
		typedocument.setGlossaryid(person.getTypedocument());
		persona.setGlossary2(typedocument);
		
		
		
		return persona;
		
	}

}
