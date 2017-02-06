package org.usfirst.frc.team3323.robot.Subsystems;

import org.usfirst.frc.team3323.robot.Commands.StopPickup;
import org.usfirst.frc.team3323.robot.Commands.PickupDirectionToggle;
import org.usfirst.frc.team3323.robot.Commands.StartPickup;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class FuelPickup extends Subsystem
{
	private SpeedController pickupMotor = new Spark(5);
	private double pickupDirection = 1;
	
	protected void initDefaultCommand()
	{
		setDefaultCommand(new StopPickup(this));
	}
	
	public StopPickup getStopPickup()
	{
		return new StopPickup(this);
	}
	
	public StartPickup getStartPickup()
	{
		return new StartPickup(this);
	}
	
	public PickupDirectionToggle getPickupDirectionToggle()
	{
		return new PickupDirectionToggle(this);
	}
	
	public void init()
    {
    	stop();
    }

	public void start()
	{
		pickupMotor.set(pickupDirection);
		
		SmartDashboard.putString("Pickup State","On");
	}
	
	public void stop()
	{
		pickupMotor.set(0);
		
		SmartDashboard.putString("Pickup State","Off");
	}
	
	public void togglePickupDirection()
	{
		if(pickupDirection>0)
			pickupDirection = -.5;
		else
			pickupDirection = .5;
		
		if(pickupDirection>0)
			   SmartDashboard.putString("Pickup Direction","Intake");
		else if(pickupDirection<0)
			   SmartDashboard.putString("Pickup Direction","Reverse");
	}
}