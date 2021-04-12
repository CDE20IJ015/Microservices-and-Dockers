package com.cognizant.loan.dao;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.loan.model.Loan;

@Component("loanDao")
public class LoanDao {
	private static ArrayList<Loan> loanList;
	public LoanDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext("loan.xml");
		this.setLoanList((ArrayList) context.getBean("loanList"));
	}

	public static ArrayList<Loan> getLoanList() {
		return loanList;
	}

	public static void setLoanList(ArrayList<Loan> loanList) {
		LoanDao.loanList = loanList;
	}

	public Loan getLoanDetails(String number) {
		for (Loan loan : loanList) {
			if(loan.getNumber().equals(number)) {
				return loan;
			}
		}
		return null;
	}

}
