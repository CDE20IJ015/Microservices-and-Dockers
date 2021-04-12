package com.cognizant.loan.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.loan.model.Loan;
import java.util.Collections;
import java.util.List;
@RestController
@RequestMapping("/loans")
public class LoanController {
	
	@GetMapping("/{number}")
	public List<Loan> getLoan(@PathVariable("number") long number){
		return Collections.singletonList(new Loan(number, "car", 4000,3258,18 ));
	}
	
}
