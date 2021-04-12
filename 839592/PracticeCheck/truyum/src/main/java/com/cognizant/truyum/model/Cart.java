package com.cognizant.truyum.model;

import java.util.ArrayList;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EntityScan
public class Cart {

	private String userId;
	private ArrayList<MenuItem> menuItemList;
    private double total;
    
    public Cart(double total, ArrayList<MenuItem> menuItemList) 
	{
		this.total = total;
		this.menuItemList = menuItemList;
	}
}
