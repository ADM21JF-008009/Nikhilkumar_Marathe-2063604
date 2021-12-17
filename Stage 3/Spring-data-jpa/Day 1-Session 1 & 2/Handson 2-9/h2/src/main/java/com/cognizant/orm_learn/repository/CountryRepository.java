package com.cognizant.orm_learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.orm_learn.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
      
      List<Country> findByNameContaining(String str);
	
	    List<Country> findByNameContainingOrderByNameAsc(String str);
	
	    List<Country> findByNameStartingWith(String s);
}
