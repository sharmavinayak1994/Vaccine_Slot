package com.java.designPattern.builderPattern;

public interface RobotBuilder {
	
	public RobotBuilder buildRobotHead(String head);
	public RobotBuilder buildRobotArms(String arms);
	public RobotBuilder buildRobotTorso(String torso);
	public RobotBuilder buildRobotlegs(String legs);
	public Robot getRobot();
}
