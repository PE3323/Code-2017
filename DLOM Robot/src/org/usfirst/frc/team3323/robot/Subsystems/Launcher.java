package org.usfirst.frc.team3323.robot.Subsystems;

import edu.wpi.first.wpilibj.SpeedController;

import org.usfirst.frc.team3323.robot.Commands.StartSupply;
import org.usfirst.frc.team3323.robot.Commands.StopSupply;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Launcher extends Subsystem {

	private SpeedController launcherMotor = new Spark(3);
	private SpeedController supplyMotor = new Spark(4);
	private Joystick joystick;
	
	public Launcher( Joystick joystick )
	{
		this.joystick = joystick;
	}
	
	@Override
    public void initDefaultCommand()
	{
		setDefaultCommand(new StopSupply(this));
    }

	public StopSupply getStopSupply()
	{
		return new StopSupply(this);
	}
	
	public StartSupply getStartSupply()
	{
		return new StartSupply(this);
	}
	
	public void init()
    {
    	off();
    }
	
	public void shoot()
	{
	supplyMotor.set(1);	
	}
	
	public void off()
	{
		supplyMotor.set(0);
		launcherMotor.set((-joystick.getAxis(AxisType.kZ)+1)/2);
	}
	
}

