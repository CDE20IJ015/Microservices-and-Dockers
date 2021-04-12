package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

@Service
public class CarDaoCollectionImpl implements CartDao {
	private static HashMap<String, Cart> userCarts = new  HashMap<String, Cart>();
	
	public void addCartItem(String userId, Long menuItemId) {
		try{
			MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
			MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);
			if(userCarts.containsKey(userId)){
				ArrayList<MenuItem> cartItems = (ArrayList<MenuItem>) userCarts.get(userId).getMenuItems();
			    cartItems.add(menuItem);				
			}
			else{
				ArrayList <MenuItem> cartMenu = new ArrayList<MenuItem>();
				cartMenu.add(menuItem);
				Cart newCart = new Cart(null,cartMenu);
				userCarts.put(userId,newCart);				
			}
		}
		catch(Exception e){
			System.out.println(e);
		}		
	}
	
	public ArrayList<MenuItem> getAllCartItems(String userId) throws CartEmptyException {
		ArrayList <MenuItem> getAllMenuItems = (ArrayList<MenuItem>) userCarts.get(userId).getMenuItems();
		if(getAllMenuItems.isEmpty()){
			throw new CartEmptyException("Cart is Empty!!");			
		}
		return getAllMenuItems;
	}
	
	public void removeCartItem(String userId, long menuItemId) {
		ArrayList <MenuItem> removeList = (ArrayList<MenuItem>) userCarts.get(userId).getMenuItems();
		for(MenuItem item: removeList){
			if(item.getId() == menuItemId){
				removeList.remove(removeList.indexOf(item));
				break;
			}
		}
		userCarts.get(userId).setMenuItems(removeList);
	}
}
