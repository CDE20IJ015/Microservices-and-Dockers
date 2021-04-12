package com.cognizant.springlearn.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

@Repository
public class EmployeeDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDao.class);

	private static List<Employee> EMPLOYEE_LIST = new ArrayList<>();

	public EmployeeDao() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("employee.xml");
		EMPLOYEE_LIST = applicationContext.getBean("employees", ArrayList.class);
	}

	public List<Employee> getAllEmployees() {
		LOGGER.info("Start");
		LOGGER.info("End");
		return EmployeeDao.EMPLOYEE_LIST;
	}

	public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
		LOGGER.info("Start");
		
		boolean updated = false;
		for (int i = 0; i < EMPLOYEE_LIST.size(); i++) {

			if (EMPLOYEE_LIST.get(i).getId() == employee.getId()) {
				EMPLOYEE_LIST.set(i, employee);
				updated = true;
			}
		}

		if (!updated)
			throw new EmployeeNotFoundException();

		LOGGER.info("End");
	}

	public void deleteEmployee(Employee employee) throws EmployeeNotFoundException {
		LOGGER.info("Start");
		
		boolean deleted = false;
		for (int i = 0; i < EMPLOYEE_LIST.size(); i++) {

			if (EMPLOYEE_LIST.get(i).getId() == employee.getId()) {
				EMPLOYEE_LIST.remove(i);
				deleted = true;
			}
		}

		if (!deleted)
			throw new EmployeeNotFoundException();

		LOGGER.info("End");
	}

}