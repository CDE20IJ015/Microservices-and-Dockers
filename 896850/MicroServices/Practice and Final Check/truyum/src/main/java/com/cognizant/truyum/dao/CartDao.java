package com.cognizant.truyum.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;

@Component
public interface CartDao {
	
	public void addCartItem(String userId, long menuItemId);
	public List<MenuItem> getAllCartItems(String userId) throws CartEmptyException;
	public void removeCartItem(String userId, long menuItemId);
	
}