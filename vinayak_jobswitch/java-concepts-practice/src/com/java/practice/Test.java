package com.java.practice;

public class Test {
	
public static void main(String[] args) {
		
		Money cash = new Money(42, "USD");
		Voucher voucher = new Voucher(42, "USD", "Amazon");

		System.out.println(voucher.equals(cash)); // As expected.
		System.out.println(cash.equals(voucher));  // That's wrong. //That violates the symmetry criteria o
	}

}
