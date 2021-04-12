package com.cognizant.springlearn.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.EmployeeService;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	public List<Employee> getAllEmployees() {
		LOGGER.info("Start");

		List<Employee> employees = employeeService.getAllEmployees();

		LOGGER.info("End");

		return employees;
	}

	@PutMapping
	public Employee updateEmployee(@RequestBody @Valid Employee employee) throws EmployeeNotFoundException {
		LOGGER.info("Start");

		employeeService.updateEmployee(employee);
	
		LOGGER.info("End");
		return employee;
	}
	
	@DeleteMapping
	public Employee deleteEmployee(@RequestBody @Valid Employee employee) throws EmployeeNotFoundException {
		LOGGER.info("Start");

		employeeService.deleteEmployee(employee);
		
		LOGGER.info("End");
		return employee;
	}

}
