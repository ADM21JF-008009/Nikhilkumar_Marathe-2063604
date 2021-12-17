package com.cognizant.HibernateMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.HibernateMapping.model.Department;
import com.cognizant.HibernateMapping.model.Employee;
import com.cognizant.HibernateMapping.model.Skill;
import com.cognizant.HibernateMapping.service.DepartmentService;
import com.cognizant.HibernateMapping.service.EmployeeService;
import com.cognizant.HibernateMapping.service.SkillService;

@SpringBootApplication
public class HibernateMappingApplication {

	private static final Logger LOGGER= LoggerFactory.getLogger(HibernateMappingApplication.class);
	public static EmployeeService employeeService;
	public static DepartmentService departmentService;
	public static SkillService skillService;
	

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(HibernateMappingApplication.class, args);
		employeeService=context.getBean(EmployeeService.class);
		departmentService=context.getBean(DepartmentService.class);
		skillService=context.getBean(SkillService.class);
		
		testGetEmployee();
		testAddEmployee();
		testUpdateEmployee();
		testGetDepartment();
		testAddSkillToEmployee();
		
		LOGGER.info("Inside main");
	}
	
	private static void testGetEmployee() {
		LOGGER.info("Start");
		Employee employee = employeeService.get(101);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Department:{}", employee.getDepartment());
		LOGGER.info("End");
		}
private static void testAddEmployee() {
		
		Employee employee = new Employee();
		employee.setId(5);
		employee.setName("Nikhil");
		employee.setSalary(16000.00);
		try {
			employee.setDateOfBirth(new SimpleDateFormat("YYYY-MM-DD").parse("1999-04-28"));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		employee.setPermanent(true);
		
		Department dept= departmentService.get(1);
		employee.setDepartment(dept);
		employeeService.saveEmployee(employee);
		
		LOGGER.debug("Employee:{}", employee);

		LOGGER.debug("Department:{}", employee.getDepartment());
	}

	private static void testUpdateEmployee() {
		LOGGER.info("Start");

		Employee employee = employeeService.get(5);
		Department dept= departmentService.get(3);
		employee.setDepartment(dept);
		employeeService.saveEmployee(employee);
		
		LOGGER.debug("Employee:{}", employee);

		LOGGER.debug("Department:{}", employee.getDepartment());

		LOGGER.info("End");
	}
	
	private static void testGetDepartment() {
		LOGGER.info("Start");

		 Department dept= departmentService.get(1);

		LOGGER.debug("Department:{}", dept);

		LOGGER.debug("Department:{}", dept.getEmployeeList());

		LOGGER.info("End");

	}
	
	private static void testAddSkillToEmployee() {
		
		Employee employee = employeeService.get(101);
		Skill skill = skillService.get(13);
		
		Set<Skill> set=employee.getSkillList();
		set.add(skill);
		
		employee.setSkillList(set);
		
		employeeService.saveEmployee(employee);
	}
}


