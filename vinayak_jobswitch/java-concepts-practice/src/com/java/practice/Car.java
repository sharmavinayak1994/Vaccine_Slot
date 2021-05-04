package com.java.practice;

public class Car {

	int gear = 0;
	String type = "";

	Car(int gear, String type) {
		this.gear = gear;
		this.type = type;
	}
	
	public void show() {
		System.out.println("This is car class");
	}

	void getDetails() {
		System.out.println("car details are : \n" + " gear : " + this.gear + "\n" + " Car type is : " + this.type);
	}
}
