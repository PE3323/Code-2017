package org.usfirst.frc.team3323.robot;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Command;

public class TestDrive extends Command {

	private SpeedController driveMotorRight;
	private SpeedController driveMotorLeft;
	
	public TestDrive(SpeedController driveMotorLeft,SpeedController driveMotorRight)
	{
		this.driveMotorLeft = driveMotorLeft;
		this.driveMotorRight = driveMotorRight;
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	protected void execute() {
		driveMotorLeft.set(-0.25);
		driveMotorRight.set(0.25);
	}
	protected void end() 
	{
	driveMotorLeft.set(0);
    driveMotorRight.set(0);	
	}
}
