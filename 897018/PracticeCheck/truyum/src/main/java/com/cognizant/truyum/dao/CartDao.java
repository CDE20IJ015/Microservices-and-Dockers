package com.cognizant.truyum.dao;

import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;
import java.util.*;

public interface CartDao {
	
	public void addCartItem(String userId,long menuItemId);
	public ArrayList<MenuItem> getAllCartItems(String userId) throws CartEmptyException;
	public void removeCartItem(String userId,long menuItemId) throws CartEmptyException;

}
