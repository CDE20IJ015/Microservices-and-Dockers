package com.cognizant.truyum.controller;

import java.text.ParseException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.dao.MenuItemDaoCollectionImpl;
import com.cognizant.truyum.model.MenuItem;

@RestController
@RequestMapping("/menu-items")
public class MenuItemController {

	@Autowired
	MenuItemDaoCollectionImpl menuItemDaoCollectionImpl;
	
	@GetMapping("/admin")
	public ArrayList<MenuItem> getMenuItemListAdmin(){
		return menuItemDaoCollectionImpl.getMenuItemListAdmin();
	}
	
	@GetMapping
	public ArrayList<MenuItem> getAllMenuItems() throws ParseException{
		return menuItemDaoCollectionImpl.getMenuItemListCustomer();
	}
	
	@GetMapping("/{id}")
	public MenuItem getMenuItem(@PathVariable long id) {
		return menuItemDaoCollectionImpl.getMenuItem(id);
	}
	
	@PutMapping("/{id}")
	public MenuItem modifyMenuItem(@RequestBody MenuItem menuItem) {
		menuItemDaoCollectionImpl.modifyMenuItem(menuItem);
		return menuItem;
	}
}
