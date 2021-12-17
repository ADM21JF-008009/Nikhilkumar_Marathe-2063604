package com.cognizant.Hibernate.Relationships.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.Hibernate.Relationships.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

//	@Query(value = "SELECT e FROM Employee e WHERE e.permanent = 1")
//	@Query(value="SELECT e FROM Employee e left join e.department d left join e.skillList WHERE e.permanent = 1")
	@Query(value = "SELECT e FROM Employee e left join fetch e.department d left join fetch e.skillList WHERE e.permanent = 1")
	List<Employee> getAllPermanentEmployees();

	

}