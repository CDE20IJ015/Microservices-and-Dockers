package com.cognizant.springlearn.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.SpringLearnApplication;
import com.cognizant.springlearn.model.Department;
import com.cognizant.springlearn.service.DepartmentService;

@RestController
public class DepartmentController {
	@Autowired
	DepartmentService departmentService;
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	
	@GetMapping("/departments")
	public ArrayList<Department> getAllDepartments() {
		LOGGER.info("Start");
		LOGGER.debug("{}", departmentService.getAllDepartments());
		return departmentService.getAllDepartments();
	}
}
