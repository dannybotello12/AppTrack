package com.apptrack.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.apptrack.rest.dto.ProfileDTO;
import com.apptrack.rest.model.Profile;
import com.apptrack.rest.repository.ProfileRepository;
import com.apptrack.rest.util.Convertidor;

@RestController
public class ProfileController {
	
	 @Autowired
	 private ProfileRepository profileRepository;
	
	 @GetMapping("/profile/{Name}")
	    public List<Profile> getProfileName(@PathVariable String Name) {
	        
		 List<Profile> resultado=profileRepository.findByName(Name);
		 return resultado;
	    }
	 
	 @GetMapping("/profile/consultaGlosary/{NameProfile}")
	    public List<ProfileDTO> getProfileGlosary(@PathVariable String NameProfile) {
	        
		 List<Profile> resultado=profileRepository.findByName(NameProfile);
		 Convertidor conversor=new Convertidor();
		 
		 return conversor.ConsultaTipoDocumentoPorPerfil(resultado);
	    }

}
