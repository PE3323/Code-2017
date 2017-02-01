package org.usfirst.frc.team3323.robot;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Command;

public class WinchWindUp extends Command {

	private SpeedController winchMotorRight;
	private SpeedController winchMotorLeft;
	
	public WinchWindUp(SpeedController winchMotorLeft,SpeedController winchMotorRight)
	{
		this.winchMotorLeft = winchMotorLeft;
		this.winchMotorRight = winchMotorRight;
	}
	
	@Override
	protected boolean isFinished()
	{
		// TODO Auto-generated method stub
		return false;
	}
	protected void execute()
	{
		winchMotorLeft.set(-1.0);
		winchMotorRight.set(1.0);
	}
    protected void end() 
    {
    winchMotorLeft.set(0);
	winchMotorRight.set(0);	
    }
}
