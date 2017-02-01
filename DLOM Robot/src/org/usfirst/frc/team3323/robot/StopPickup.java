package org.usfirst.frc.team3323.robot;

import edu.wpi.first.wpilibj.command.Command;

public class StopPickup extends Command {
	
	private FuelPickup fuelPickup;

	public StopPickup(FuelPickup fuelPickup)
	{
		requires(fuelPickup);
		this.fuelPickup = fuelPickup;
	}
	
	protected void execute()
	{
		fuelPickup.stop();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
