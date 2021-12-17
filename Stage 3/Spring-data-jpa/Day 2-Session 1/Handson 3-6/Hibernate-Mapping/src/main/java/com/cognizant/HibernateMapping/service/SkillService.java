package com.cognizant.HibernateMapping.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.HibernateMapping.HibernateMappingApplication;
import com.cognizant.HibernateMapping.model.Employee;
import com.cognizant.HibernateMapping.model.Skill;
import com.cognizant.HibernateMapping.repository.EmployeeRepository;
import com.cognizant.HibernateMapping.repository.SkillRepository;

@Service
public class SkillService {
	
	@Autowired
	private SkillRepository skillRepository;

	private static final Logger LOGGER= LoggerFactory.getLogger(HibernateMappingApplication.class);
	
	@Transactional
	public Skill get(int id) {
	LOGGER.info("Start");
	return skillRepository.findById(id).get();
	}
	
	@Transactional
	public void save(Skill skill) {
	LOGGER.info("Start");
	skillRepository.save(skill);
	LOGGER.info("End");
	}


}
