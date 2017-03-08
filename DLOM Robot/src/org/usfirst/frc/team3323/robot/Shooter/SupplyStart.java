package org.usfirst.frc.team3323.robot.Shooter;

import edu.wpi.first.wpilibj.command.Command;

public class SupplyStart extends Command {

	private Supply supply;
	
	public SupplyStart(Supply test)
	{
		requires(test);
		this.supply = test;
	}
	
	public void execute() 
	{
		supply.supplyStart();
	}

	public void end()
	{
		supply.supplyStop();	
	}
	
	protected boolean isFinished()
	{
		return false;
	}
}
