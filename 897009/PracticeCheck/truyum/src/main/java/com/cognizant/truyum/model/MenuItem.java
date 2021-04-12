package com.cognizant.truyum.model;

import java.util.Date;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EntityScan
public class MenuItem {

	private long id;
	private String name,category;
	private float price;
	private boolean active,freeDelivery;
	private Date dateOfLaunch;
	
}
