package com.java.designPattern.builderPattern;

public class AndroidRoboBuilder implements RobotBuilder {

	private Robot robo;
	
	public AndroidRoboBuilder() {
		this.robo = new Robot();
	}
	
	@Override
	public AndroidRoboBuilder buildRobotHead(String head) {
		robo.setHead(head);
		return this;
	}

	@Override
	public AndroidRoboBuilder buildRobotArms(String arms) {
		robo.setArms(arms);
		return this;
	}

	@Override
	public AndroidRoboBuilder buildRobotTorso(String torso) {
		robo.setTorso(torso);
		return this;
	}

	@Override
	public AndroidRoboBuilder buildRobotlegs(String legs) {
		robo.setLegs(legs);
		return this;
	}

	@Override
	public Robot getRobot() {
		
		return this.robo;
	}

}
