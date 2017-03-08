package org.usfirst.frc.team3323.robot.Winch;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Winch extends Subsystem
{
	private SpeedController winchMotorLeft = new Talon(3);
	private SpeedController winchMotorRight = new Talon(2);
	private PowerDistributionPanel powerBoard;
	
    public Winch(PowerDistributionPanel powerBoard)
    {
    	this.powerBoard = powerBoard;
	}


	public void initDefaultCommand()
    {
        setDefaultCommand(new WinchStop(this));
    }
    
    
    public WinchWindUp getWinchWindUp() {
		return new WinchWindUp(this);
	}
	
	public WinchStop getWinchStop()
	{
		return new WinchStop(this);
	}
	
	public void stop()
    {
    	winchMotorLeft.set(0);
		winchMotorRight.set(0);		
    }
	
	public void up()
    {
    	winchMotorLeft.set(-1);
		winchMotorRight.set(-1);		
    }
	
	public void down()
    {
    	winchMotorLeft.set(.05);
		winchMotorRight.set(.05);
		
    }
	
	public void info()
	{
		SmartDashboard.putNumber("Winch Right", powerBoard.getCurrent(3));
		SmartDashboard.putNumber("Winch Left", powerBoard.getCurrent(2));
	}
}

