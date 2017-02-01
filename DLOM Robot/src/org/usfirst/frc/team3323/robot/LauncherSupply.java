package org.usfirst.frc.team3323.robot;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Command;

public class LauncherSupply extends Command {

	private SpeedController fuelSupplyMotor;
	
	public LauncherSupply(SpeedController fuelSupplyMotor)
	{
		this.fuelSupplyMotor = fuelSupplyMotor;
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	protected void execute() {
		fuelSupplyMotor.set(0.5);
	}
	protected void end() 
	{
	fuelSupplyMotor.set(0);	
	}
}