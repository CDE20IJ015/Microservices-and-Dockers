package com.cognizant.truyum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.truyum.model.*;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.service.MenuItemService;

@RequestMapping("/menu-items")
@RestController
public class MenuItemController {
	
	@Autowired
	MenuItemService service;
	
	@GetMapping
	public List<MenuItem> getAllMenuItems(){
		return service.getMenuItemListCustomer();
	}
	
	@GetMapping("/{id}")
	public MenuItem getMenuItem(@PathVariable(name="id") long id){
		return service.getMenuItem(id);
	}
	
	@PutMapping()
	public void modifyMenuItem(@RequestBody MenuItem menuItem) {
		service.modifyMenuItem(menuItem);
	}
	
}
