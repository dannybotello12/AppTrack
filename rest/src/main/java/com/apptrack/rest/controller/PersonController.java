package com.apptrack.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apptrack.rest.dto.PersonaDTO;
import com.apptrack.rest.model.Person;
import com.apptrack.rest.repository.PersonRepository;
import com.apptrack.rest.util.Convertidor;;

@RestController
public class PersonController {
	
	
	
	
	 @Autowired
	 private PersonRepository personRepository;
	
	 
	 @GetMapping("/person")
	    public List<Person> getPersons(Pageable pageable) {
	        return personRepository.findAll();
	    }
	 
	 @PostMapping("/CreatePerson")
	    public ResponseEntity<Object>  createPerson(@Valid @RequestBody Person person) {
	      
		 Person personcreada=new  Person();
		 try
		 {
			 personcreada=personRepository.save(person);
		 }
		 catch (Exception e) {
			 return new ResponseEntity<Object>(personcreada, HttpStatus.BAD_REQUEST);
		}
		 return new ResponseEntity<Object>(personcreada, HttpStatus.OK);
	       
	    }
	 
	 @PostMapping("/CreatePersonGson")
	    public ResponseEntity<Object>  createPersonGson( @RequestBody PersonaDTO datos) {
		 
		 Person personcreada=new  Person();
		 try
		 {
		   
		   Convertidor convertidor=new Convertidor();
		   Person person= convertidor.personaDTOtoPerson(datos);
		   personcreada= personRepository.save(person);
	        }
	        catch (Exception e) {
				 return new ResponseEntity<Object>(personcreada, HttpStatus.BAD_REQUEST);
			}
			 return new ResponseEntity<Object>(personcreada, HttpStatus.OK);
		       
		    }

	 @GetMapping("/person/{Email}")
	    public List<Person> getPersonsId(@PathVariable String Email) {
	        
		 List<Person> resultado=personRepository.findByEmail(Email);
		 return resultado;
	    }
	 
	


}
