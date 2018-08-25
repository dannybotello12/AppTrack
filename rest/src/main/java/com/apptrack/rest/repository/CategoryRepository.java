package com.apptrack.rest.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.apptrack.rest.model.Category;

public interface CategoryRepository extends  JpaRepository<Category, Long>, Serializable  { 

	List<Category> findByName(@Param("name") String name);
	
}
