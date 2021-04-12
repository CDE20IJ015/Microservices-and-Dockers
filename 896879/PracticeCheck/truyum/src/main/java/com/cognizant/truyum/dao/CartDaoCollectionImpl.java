package com.cognizant.truyum.dao;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.exception.CartEmptyException;
import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class CartDaoCollectionImpl implements CartDao {
	
	private static HashMap<String,Cart> userCarts;

	public CartDaoCollectionImpl()
	{
		if(userCarts == null)
		{
			userCarts = new  HashMap<String,Cart>();
			
		}
	}

	//@Override
	public void addCartItem(String userId, long menuItemId) {
		
		try
		{
			MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
			MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);
			if(userCarts.containsKey(userId))
			{
				ArrayList<MenuItem> cartItems = userCarts.get(userId).getMenuItemList();
			    cartItems.add(menuItem);
				
			}
			else
			{
				ArrayList <MenuItem> cartMenu = new ArrayList<MenuItem>();
				cartMenu.add(menuItem);
				Cart newCart = new Cart(0,cartMenu);
				userCarts.put(userId,newCart);
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}


	public ArrayList<MenuItem> getAllCartItems(String userId) throws CartEmptyException {

		ArrayList <MenuItem> getAll = userCarts.get(userId).getMenuItemList();
		if(getAll.isEmpty())
		{
			throw new CartEmptyException("No Item(s) Found in Cart");
			
		}
		else
		{
			float value =0.00f;
			for(MenuItem x : getAll)
			{
				value = value + x.getPrice();
			}
			userCarts.get(userId).setTotal(value);
		}
		return getAll;
	}

	@Override
	public void removeCartItem(String userId, long menuItemId) throws CartEmptyException {
		
		// TODO Auto-generated method stub
		ArrayList <MenuItem> removeList = userCarts.get(userId).getMenuItemList();
		for(MenuItem x: removeList)
		{
			if(x.getId() == menuItemId)
			{
				removeList.remove(removeList.indexOf(x));
				break;
			}
		}
		userCarts.get(userId).setMenuItemList(removeList);
		
	}


}
