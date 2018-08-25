package com.apptrack.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.apptrack.rest.model.Glossary;
import com.apptrack.rest.repository.GlossaryRepository;

@RestController
public class GlossaryController {
	
	 @Autowired
	 private GlossaryRepository glossaryRepository;
	 
	 @GetMapping("/glossary/{name}")
	    public List<Glossary> getGlosarioName(@PathVariable String name) {
	        
		 List<Glossary> resultado=glossaryRepository.findByName(name);
		 return resultado;
	    }

}
