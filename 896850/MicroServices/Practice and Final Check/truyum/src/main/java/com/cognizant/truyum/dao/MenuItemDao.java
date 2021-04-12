package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.*;

@Component
public interface MenuItemDao {
	public List<MenuItem> getMenuItemListCustomer();
	public List<MenuItem> getMenuItemListAdmin();
	public void modifyMenuItem(MenuItem menuItem);
	public MenuItem getMenuItem(long id);
	
}
