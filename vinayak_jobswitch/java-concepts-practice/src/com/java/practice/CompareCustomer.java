package com.java.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompareCustomer implements Comparator<Customer> {

	public int compare(Customer c1, Customer c2) {
		// TODO Auto-generated method stub
		return c1.name.compareTo(c2.name);
	}
	
	public void getCustomerList(List<Customer> customers){
		for(Customer customer : customers) {
			System.out.println(customer.age + " " + customer.name);
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Customer> customers = new ArrayList<>();
		customers.add(new Customer("Aaa", 51));
		customers.add(new Customer("Aab", 57));
		customers.add(new Customer("Raj", 50));
		customers.add(new Customer("Ram", 15));
		customers.add(new Customer("Vinayak", 26));
		customers.add(new Customer("Tutu", 29));
		customers.add(new Customer("Roy", 10));
		customers.add(new Customer("Aca", 12));
		CompareCustomer compare = new CompareCustomer();
		Collections.sort(customers, compare);
		compare.getCustomerList(customers);
		
	}
}
