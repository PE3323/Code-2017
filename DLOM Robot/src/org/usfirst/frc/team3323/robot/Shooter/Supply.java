package org.usfirst.frc.team3323.robot.Shooter;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Supply extends Subsystem {

	private SpeedController supplyMotor = new Spark(0);
	private PowerDistributionPanel powerBoard;
	
	public Supply(PowerDistributionPanel powerBoard)
	{
		this.powerBoard = powerBoard;
	}
	
    public void initDefaultCommand()
    {
    	setDefaultCommand(null);
    }
    
    public SupplyStart getStartSupply()
	{
		return new SupplyStart(this);
	}
    
    public void supplyStart()
	{
		supplyMotor.set(.5);
	}
	
	public void supplyStop()
	{
		supplyMotor.set(0);
	}
	
	public void info()
	{
		SmartDashboard.putNumber("Supply", powerBoard.getCurrent(1));
	}
}

