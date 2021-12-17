package com.cognizant.ormlearn;

import java.util.List;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;
import com.cognizant.spring_learn.service.exception.CountryNotFoundException;

@SpringBootApplication
//@ComponentScan({"com.*"})
public class OrmLearnApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	
	private static CountryService countryService;
	private static void testGetAllCountries() {

		LOGGER.info("Start");

		List<Country> countries =countryService.getAllCountries();

		LOGGER.debug("countries={}", countries);

		LOGGER.info("End");

		}
	
	private static void getAllCountriesTest() throws CountryNotFoundException  {
		LOGGER.info("Start");
		Country country = countryService.findCountryByCode("IN");
		 LOGGER.debug("Country:{}", country);
		LOGGER.info("End");
		}
	
	private static void testAddCountry() throws CountryNotFoundException {
		Country c=new Country();
		c.setCode("TC");
		c.setName("Test Country");
	
		countryService.addCountry(c);
		
		LOGGER.info("Start");
		Country country = countryService.findCountryByCode("TC");
		 LOGGER.debug("Country:{}", country);
		LOGGER.info("End");
		
	}
	private static void testUpdateCountry() throws CountryNotFoundException {
		
		LOGGER.info("Start");
		countryService.updateCountry("TC"," I N D I A");
		 LOGGER.debug("Update Successfull");
		LOGGER.info("End");
		
	}
	
	private static void testDeleteCountry() {
		LOGGER.info("Start");
		countryService.deleteCountry("TG");
		 LOGGER.debug("TG Delete Successfull");
		LOGGER.info("End");
	}
	
	


	public static void main(String[] args) {
		
				ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
				countryService = context.getBean(CountryService.class);
				testGetAllCountries();
				LOGGER.info("Inside main");
		
		
	}
	

}
