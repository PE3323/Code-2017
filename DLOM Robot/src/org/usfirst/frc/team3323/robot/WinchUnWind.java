package org.usfirst.frc.team3323.robot;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Command;

public class WinchUnWind extends Command {

	private SpeedController winchMotorRight;
	private SpeedController winchMotorLeft;
	
	public WinchUnWind(SpeedController winchMotorLeft,SpeedController winchMotorRight)
	{
		this.winchMotorLeft = winchMotorLeft;
		this.winchMotorRight = winchMotorRight;
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	protected void execute() {
		winchMotorLeft.set(0.5);
		winchMotorRight.set(-0.5);
	}
	protected void end() 
	{
	winchMotorLeft.set(0);
    winchMotorRight.set(0);	
	}
}
