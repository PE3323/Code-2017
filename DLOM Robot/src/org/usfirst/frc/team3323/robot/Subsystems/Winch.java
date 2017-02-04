package org.usfirst.frc.team3323.robot.Subsystems;

import org.usfirst.frc.team3323.robot.Commands.WinchStop;
import org.usfirst.frc.team3323.robot.Commands.WinchUnWind;
import org.usfirst.frc.team3323.robot.Commands.WinchWindUp;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Winch extends Subsystem
{
	private SpeedController winchMotorLeft = new Talon(7);
	private SpeedController winchMotorRight = new Talon(6);
	
    public void initDefaultCommand()
    {
        setDefaultCommand(new WinchStop(this));
    }
    
    
    public WinchWindUp getWinchWindUp() {
		return new WinchWindUp(this);
	}


	public WinchUnWind getWinchUnWind()
	{
		return new WinchUnWind(this);
	}
	
	public WinchStop getWinchStop()
	{
		return new WinchStop(this);
	}
	
	public void init()
    {
    	stop();
    }
	
	public void stop()
    {
    	winchMotorLeft.set(0);
		winchMotorRight.set(0);		
    }
	
	public void up()
    {
    	winchMotorLeft.set(1);
		winchMotorRight.set(1);		
    }
	
	public void down()
    {
    	winchMotorLeft.set(-.25);
		winchMotorRight.set(-.25);		
    }
	
}

