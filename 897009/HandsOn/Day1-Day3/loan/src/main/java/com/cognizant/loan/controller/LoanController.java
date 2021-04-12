package com.cognizant.loan.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.loan.model.loan;

@RestController
@RequestMapping("/loans")
public class LoanController {

	@GetMapping("/{number}")
	public List<loan> getLoan() {
		return Collections.singletonList(new loan("00987987973432","car",400000,3258,18));
	}
}
