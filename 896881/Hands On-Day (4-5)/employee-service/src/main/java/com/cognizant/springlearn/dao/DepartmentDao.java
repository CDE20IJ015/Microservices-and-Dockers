package com.cognizant.springlearn.dao;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.springlearn.model.Department;

public class DepartmentDao {
	
		private static ArrayList<Department> DEPARTMENT_LIST;

		public DepartmentDao() {
			ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
			this.setDEPARTMENT_LIST((ArrayList) context.getBean("departmentList"));
		}

		public ArrayList<Department> getAllDepartments() {
			return DEPARTMENT_LIST;
		}

		public void setDEPARTMENT_LIST(ArrayList<Department> DEPARTMENT_LIST) {
			this.DEPARTMENT_LIST = DEPARTMENT_LIST;
		}
	


}
