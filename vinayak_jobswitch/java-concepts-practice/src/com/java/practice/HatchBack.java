package com.java.practice;

public class HatchBack extends Car{

	String driveType = "";
	
	public String getDriveType() {
		return driveType;
	}

	public void setDriveType(String driveType) {
		this.driveType = driveType;
	}

	public HatchBack(int gear, String type, String driveType) {
		super(gear, type);
		this.driveType = driveType;
	}
	
	public void show() {
		super.show();
		System.out.println("this is hatchback");
	}
	
	@Override
	void getDetails() {
		super.getDetails();
		System.out.println("Drive type is : "+driveType);
	}
	
	public static void main(String[] args) {
		HatchBack car = new HatchBack(5, "HatchBack", "Manual");
		car.getDetails();
		car.show();
	}
}
