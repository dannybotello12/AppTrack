package com.apptrack.rest.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apptrack.rest.model.Person;



@Repository
public interface PersonRepository extends  JpaRepository<Person, Long>, Serializable {
	
	List<Person> findByEmail(@Param("email") String email);
	
	
}
