package com.cognizant.account.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.account.model.Account;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	@GetMapping("/{number}")
	public List<Account> getAccounts(){
		return Collections.singletonList(new Account("00987987973432","savings",234343));
	}
}
