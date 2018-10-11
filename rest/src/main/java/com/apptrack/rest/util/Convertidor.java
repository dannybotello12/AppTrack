package com.apptrack.rest.util;

import java.util.List;
import java.util.Set;

import com.apptrack.rest.dto.PersonaDTO;
import com.apptrack.rest.dto.ProfileDTO;
import com.apptrack.rest.model.Glossary;
import com.apptrack.rest.model.Person;
import com.apptrack.rest.model.Profile;
import com.apptrack.rest.model.Profiledocument;

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
	
	public List<ProfileDTO> ConsultaTipoDocumentoPorPerfil (List<Profile> profile)
	{
		
		 List<ProfileDTO> resultado = null;
		 
		 for (Profile Profile : profile) {
			 
			 Integer profileid=Profile.getProfileid();
			 String nameProfile =Profile.getName();
			 
			 Set<Profiledocument>  profiledocument = Profile.getProfiledocuments();
			 
			 for (Profiledocument Profiledocument : profiledocument) {
			
				 Integer profiledocumentid= Profiledocument.getProfiledocumentid();
				 String glosaryName=Profiledocument.getGlossary().getName(); 
				 Integer glossaryid= Profiledocument.getGlossary().getGlossaryid();
				 
				 ProfileDTO nuevo= new ProfileDTO(profiledocumentid,profileid,glossaryid,nameProfile,glosaryName);
				 
				 resultado.add(nuevo);
				 
			}
			
		}
		 
		 return resultado;
		
	}

}
