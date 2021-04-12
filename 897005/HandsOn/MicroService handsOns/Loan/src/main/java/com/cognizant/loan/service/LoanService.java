package com.cognizant.loan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.loan.dao.LoanDao;
import com.cognizant.loan.model.Loan;

@Service
public class LoanService {
	@Autowired
	LoanDao loanDao;

	public Loan getLoanDetails(String number) {
		return loanDao.getLoanDetails(number);
	}
}
