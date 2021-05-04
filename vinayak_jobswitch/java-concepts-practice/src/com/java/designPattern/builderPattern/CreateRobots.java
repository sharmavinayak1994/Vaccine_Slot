package com.java.designPattern.builderPattern;

public class CreateRobots {

	public static void main(String[] args) {
		RobotBuilder roboBuild = new AndroidRoboBuilder();
		Robot robo = roboBuild.buildRobotArms("CarbonFiber").buildRobotHead("Metallic Head").getRobot();
		System.out.println(robo);
	}
}

