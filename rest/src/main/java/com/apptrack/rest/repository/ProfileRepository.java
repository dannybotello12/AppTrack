package com.apptrack.rest.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apptrack.rest.model.Profile;

@Repository
public interface ProfileRepository  extends  JpaRepository<Profile, Long>, Serializable {

	List<Profile> findByName (@Param("name") String name);
	
	
	
	@Query(" FROM Profile p where p.name = :name") 
	public List<Profile> FindAllProfile(@Param("name") String name);
	

}
