package com.cognizant.HibernateMapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.HibernateMapping.model.Employee;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Integer>{

}