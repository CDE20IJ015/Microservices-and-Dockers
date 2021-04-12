package com.cognizant.springlearn.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.springlearn.dao.DepartmentDao;
import com.cognizant.springlearn.model.Department;

@Service
public class DepartmentService {
		@Transactional
		public ArrayList<Department> getAllDepartments() {
			return new DepartmentDao().getAllDepartments();
		}
}
