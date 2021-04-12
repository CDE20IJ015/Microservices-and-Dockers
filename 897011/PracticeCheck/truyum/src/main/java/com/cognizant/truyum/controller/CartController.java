package com.cognizant.truyum.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.dao.CartDaoCollectionImpl;
import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;

@RestController
@RequestMapping("/carts")
public class CartController {

	@Autowired
	CartDaoCollectionImpl cartDaoCollectionImpl;
	
	@Autowired
	CartDao cartDao;
	
	@GetMapping("/{userId}")
	public ArrayList<MenuItem> getAllCartItems(@PathVariable String userId) throws CartEmptyException {
		return cartDaoCollectionImpl.getAllCartItems(userId);
	}
	
	@PostMapping("/{userId}/{menuItemId}")
	public void addCartitem(@RequestBody @Valid @PathVariable String userId, @RequestBody @Valid @PathVariable long menuItemId) {
		cartDaoCollectionImpl.addCartItem(userId, menuItemId);
	}
	
	@DeleteMapping("/{userId}/{menuItemId}")
	public void deleteCartItems(@PathVariable String userId, @PathVariable long menuItemId) throws CartEmptyException {
		cartDao.removeCartItem(userId, menuItemId);
	}
	
}
