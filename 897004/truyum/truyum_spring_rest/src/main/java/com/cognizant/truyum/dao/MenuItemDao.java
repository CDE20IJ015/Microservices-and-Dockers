package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.ArrayList;

import com.cognizant.truyum.model.MenuItem;

public interface MenuItemDao {
	public ArrayList<MenuItem> getMenuItemListAdmin();
	public ArrayList<MenuItem> getMenuItemListCustomer() throws ParseException;
	public void modifyMenuItem(MenuItem menuItem);
	public MenuItem getMenuItem(long menuItemId);
}
