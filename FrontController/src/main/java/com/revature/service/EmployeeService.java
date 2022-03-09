package com.revature.service;

import java.util.Optional;

import com.revature.dao.EmployeeDao;
import com.revature.model.Employee;

public class EmployeeService {
	
	// the service class relies on (depends on the Dao)
	private EmployeeDao edao;
	
	
	//Dependency injection by way of Constructor Injection
	
	//Constuctor injection is a sophisticated way of ensuring no EmployeeService
	//object is instantiated without passing through an EmployeeDao object
	//constructor injection
	public EmployeeService(EmployeeDao edoa) {
		this.edao = edao;	
	}
	
	/**
	 * This method will return an employee that has succesfully logged in, meaning that their username
	 * and password match a unique record in the DB
	 * 
	 * return null if it doesn't match a record
	 * 
	 * @param username -- comes from a parameter from an HTML form
	 * @param password -- comes from a parameter from an HTML form
	 * @return Employee object complete with the Employee's first and last name
	 */
	public Employee confirmLogin(String username, String password) {
		
		Optional<Employee> possibleEmp = edao.findAll()
				.stream()
				.filter(e-> (e.getUsername().equals(username) && e.getPassword().equals(password)))
				.findFirst();
		
		// IF the employee object is present, return it, otherwise return null
		return (possibleEmp.isPresent() ? possibleEmp.get() : null);
	}
	
	
	public int insert(Employee e) {
		return edao.insert(e);
	}

}
