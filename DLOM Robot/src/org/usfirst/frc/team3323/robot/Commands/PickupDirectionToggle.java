package org.usfirst.frc.team3323.robot.Commands;

import org.usfirst.frc.team3323.robot.Subsystems.FuelPickup;

import edu.wpi.first.wpilibj.command.Command;

public class PickupDirectionToggle extends Command{

	private FuelPickup fuelPickup;

	public PickupDirectionToggle(FuelPickup fuelPickup)
	{
		requires(fuelPickup);
		this.fuelPickup = fuelPickup;
	}
	protected void execute() {
		        fuelPickup.togglePickupDirection();
		    
		}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

}