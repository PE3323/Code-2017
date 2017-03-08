package org.usfirst.frc.team3323.robot.FuelPickup;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class FuelPickup extends Subsystem
{
	private SpeedController pickupMotor = new Spark(7);
	private PowerDistributionPanel powerBoard;
	
	public FuelPickup(PowerDistributionPanel powerBoard)
	{
		this.powerBoard = powerBoard;
	}

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

	public void start()
	{
		pickupMotor.set(-.777777);
		
		SmartDashboard.putString("Pickup State","On");
	}
	
	public void stop()
	{
		pickupMotor.set(0);
		
		SmartDashboard.putString("Pickup State","Off");
	}
	
	public void info()
	{
		SmartDashboard.putNumber("Fuel Pickup", powerBoard.getCurrent(15));
	}
}