package com.java.designPattern.builderPattern;

public class Robot {

	private String head;
	private String arms;
	private String torso;
	private String legs;
	
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getArms() {
		return arms;
	}
	public void setArms(String arms) {
		this.arms = arms;
	}
	public String getTorso() {
		return torso;
	}
	public void setTorso(String torso) {
		this.torso = torso;
	}
	public String getLegs() {
		return legs;
	}
	public void setLegs(String legs) {
		this.legs = legs;
	}
	@Override
	public String toString() {
		return "Robot [head=" + head + ", arms=" + arms + ", torso=" + torso + ", legs=" + legs + "]";
	}
}
