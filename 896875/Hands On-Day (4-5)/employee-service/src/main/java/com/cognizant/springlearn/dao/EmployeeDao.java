package com.cognizant.springlearn.dao;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;
@Component
public class EmployeeDao {
	private static ArrayList<Employee> EMPLOYEE_LIST;

	public EmployeeDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		this.setEMPLOYEE_LIST((ArrayList) context.getBean("employeeList"));
	}
	public void updateEmployee(Employee employee) throws EmployeeNotFoundException{
		int id=employee.getId();
		boolean success=false;
		for (Employee employee2 : EMPLOYEE_LIST) {
			if(employee2.getId()==id) {
				success=true;
				employee2.setName(employee.getName());
				employee.setSalary(employee.getSalary());
				employee.setPermanent(employee.isPermanent());
				employee.setDateOfBirth(employee.getDateOfBirth());
				employee.setDepartment(employee.getDepartment());
			}
		}
		if(!success) {
			throw new EmployeeNotFoundException();
		}
	}

	public ArrayList<Employee> getAllEmployees() {
		return EMPLOYEE_LIST;
	}

	public static void setEMPLOYEE_LIST(ArrayList<Employee> eMPLOYEE_LIST) {
		EMPLOYEE_LIST = eMPLOYEE_LIST;
	}
	public void deleteEmployee(int id) throws EmployeeNotFoundException {
		boolean success=false;
		for (Employee employee : EMPLOYEE_LIST) {
			if(employee.getId()==id) {
				success=true;
				EMPLOYEE_LIST.remove(employee);
			}
		}
		if(!success) {
			throw new EmployeeNotFoundException();
		}
	}
	public Employee getEmployee(long id) throws EmployeeNotFoundException {
		Employee e=null;
		for (Employee employee : EMPLOYEE_LIST) {
			if(employee.getId()==id) {
				return employee;
			}
		}
		if(e==null) {
			throw new EmployeeNotFoundException();
		}
		return null;
	}

}
