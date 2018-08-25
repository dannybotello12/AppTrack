package com.apptrack.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.apptrack.rest.model.Category;
import com.apptrack.rest.repository.CategoryRepository;

@RestController
public class CategoryController {
	
	 @Autowired
	 private CategoryRepository categoryRepository;
	 
	 
	 @GetMapping("/category/{name}")
	    public List<Category> getCategoryName(@PathVariable String name) {
	        
		 List<Category> resultado=categoryRepository.findByName(name);
		 return resultado;
	    }

}
