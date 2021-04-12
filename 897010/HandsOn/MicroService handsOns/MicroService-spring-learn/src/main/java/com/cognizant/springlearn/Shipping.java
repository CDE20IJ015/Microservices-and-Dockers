package com.cognizant.springlearn;

import java.util.List;

public class Shipping {
	public static void main(String args[]) {
		
		int truckSize=6;
		long [] box = {3,1,6};
		long [] unitsPerBox  = {2,7,4};
		
		
		long max= Long.MIN_VALUE;
		long cap=0;
		
		for(int i=0;i<box.length;i++) {
			cap += box[i];
			if(cap<=truckSize) {
				long endingMaxValue=0;
				endingMaxValue += box[i]*unitsPerBox[i];
				if(max<endingMaxValue) {
					max=endingMaxValue;
					System.out.println("debug"+max);
				}
			}
			
			
			
			//check[i] = 
		}
		System.out.println(max);
		
	}
    
	
	
}
