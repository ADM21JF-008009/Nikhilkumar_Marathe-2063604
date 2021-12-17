package com.cognizant.HibernateMapping.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.HibernateMapping.HibernateMappingApplication;
import com.cognizant.HibernateMapping.model.Employee;
import com.cognizant.HibernateMapping.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	private static final Logger LOGGER= LoggerFactory.getLogger(HibernateMappingApplication.class);
	
	@Transactional
	public Employee get(int id) {
	LOGGER.info("Start");
	return employeeRepository.findById(id).get();
	}
	
	@Transactional
	public void saveEmployee(Employee employee) {
	LOGGER.info("Start");
	employeeRepository.save(employee);
	LOGGER.info("End");
	}

}
