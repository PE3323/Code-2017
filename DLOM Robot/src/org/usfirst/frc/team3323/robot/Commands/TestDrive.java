package org.usfirst.frc.team3323.robot.Commands;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Command;

public class TestDrive extends Command {

	private SpeedController driveMotorRight;
	private SpeedController driveMotorLeft;
	private RobotDrive Robotdrive;
	
	public TestDrive(SpeedController driveMotorLeft,SpeedController driveMotorRight)
	{
		this.driveMotorLeft = driveMotorLeft;
		this.driveMotorRight = driveMotorRight;
	}
	
	@Override
	protected boolean isFinished()
	{
		return false;
	}
	protected void execute() {
		Robotdrive.drive(.25, 0);
	}
	protected void end() 
	{
	driveMotorLeft.set(0);
    driveMotorRight.set(0);	
	}
}
