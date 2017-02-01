package org.usfirst.frc.team3323.robot;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class FuelPickup extends Subsystem
{

	private SpeedController fuelPickupMotor;
	private double pickupDirection = 1;

	public FuelPickup(SpeedController feederMotor) 
	{
		this.fuelPickupMotor = feederMotor;
	}
	
	@Override
	protected void initDefaultCommand()
	{
		setDefaultCommand(new StopPickup(this));
	}

	public void start()
	{
		fuelPickupMotor.set(pickupDirection);
		
		SmartDashboard.putString("Pickup State","On");
	}
	
	public void stop()
	{
		fuelPickupMotor.set(0);
		
		SmartDashboard.putString("Pickup State","Off");
	}
	
	public void togglePickupDirection()
	{
		if(pickupDirection>0)
			pickupDirection = -1;
		else
			pickupDirection = 1;
		
		if(pickupDirection>0)
			   SmartDashboard.putString("Pickup Direction","Intake");
		else if(pickupDirection<0)
			   SmartDashboard.putString("Pickup Direction","Reverse");
	}
}