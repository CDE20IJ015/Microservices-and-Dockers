package com.cognizant.truyum.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;

@RestController
@RequestMapping("/carts")
public class CartController {
	@Autowired
	CartDao cartDao;
	
	@PostMapping("/{userId}/{menuItemId}")
	public void addCartItem(@PathVariable String userId, @PathVariable long menuItemId) {
		cartDao.addCartItem(userId, menuItemId);
	}
	
	@GetMapping("/{userId}")
	public ArrayList<MenuItem> getAllCartItems(@PathVariable String userId) throws CartEmptyException{
		return cartDao.getAllCartItems(userId);
	}
	
	@DeleteMapping("/{userId}/{menuItemId}")
	public void deleteCartItems(@PathVariable String userId, @PathVariable long menuItemId) {
		cartDao.removeCartItem(userId, menuItemId);
	}
}
