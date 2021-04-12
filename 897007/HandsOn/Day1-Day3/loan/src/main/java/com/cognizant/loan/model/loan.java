package com.cognizant.loan.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class loan {

	private String number;
	private String type;
	private double loan;
	private double emi;
	private int tenure;
}
