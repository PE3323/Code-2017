package org.usfirst.frc.team3323.robot.Commands;

import org.usfirst.frc.team3323.robot.Subsystems.FuelPickup;

import edu.wpi.first.wpilibj.command.Command;

public class StartPickup extends Command {

	private FuelPickup fuelPickup;
	
	public StartPickup(FuelPickup fuelPickup)
	{
		requires(fuelPickup);
		this.fuelPickup = fuelPickup;
	}
	protected void execute() {
		        fuelPickup.start();
		    
		}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
}
