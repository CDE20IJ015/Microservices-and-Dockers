package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.catalina.core.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.model.MenuItem;




public class MenuItemDaoCollectionImpl implements MenuItemDao{
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("truyum.xml");
	ArrayList<MenuItem> menuItemList = (ArrayList<MenuItem>) context.getBean("menuItemList",ArrayList.class);
	
	ArrayList<MenuItem> customerList;
	
	public ArrayList<MenuItem> getMenuItemListAdmin(){	
		
		return menuItemList;
	} 
	
	public ArrayList<MenuItem> getMenuItemListCustomer() throws ParseException{
		
		customerList = new ArrayList<MenuItem>();
		SimpleDateFormat simpleDateFormat = (SimpleDateFormat) context.getBean("dateFormat");
		for(MenuItem item : menuItemList){
			Date date = item.getDateOfLaunch();
			String today = "19/08/2019";
			Date tdate = simpleDateFormat.parse(today);
			if(date.before(tdate) || date.equals(tdate)){
				if(item.isActive()){
					customerList.add(item);
				}
			}
		}
		return customerList;
	}	
	
	public void modifyMenuItem(MenuItem menuItem) {
		
		for(int i=0;i<menuItemList.size();i++) {
			MenuItem item = menuItemList.get(i);
			if(item.getId() == menuItem.getId()) {
				//menuItemList.set(i+1, menuItem);
				item.setName(menuItem.getName());
				item.setActive(menuItem.isActive());
				item.setCategory(menuItem.getCategory());
				item.setDateOfLaunch(menuItem.getDateOfLaunch());
				item.setCategory(menuItem.getCategory());
				item.setFreeDelivery(menuItem.isFreeDelivery());
			}
		}
		 System.out.println(menuItemList);
	}
	
	 public MenuItem getMenuItem(long menuItemId) {
		
		for(MenuItem item: menuItemList){
			if(item.getId()== menuItemId){
				return item;
			}
		}
		return null;
	}
}
