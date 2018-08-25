package com.apptrack.rest.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apptrack.rest.model.Glossary;
@Repository
public interface GlossaryRepository extends  JpaRepository<Glossary, Long>, Serializable  {
	
	List<Glossary> findByName(@Param("name") String name);

}
