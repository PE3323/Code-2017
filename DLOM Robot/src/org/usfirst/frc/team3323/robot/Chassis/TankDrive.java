package org.usfirst.frc.team3323.robot.Chassis;

import edu.wpi.first.wpilibj.command.Command;

public class TankDrive extends Command
{
	private Chassis driveTrain;
	
	public TankDrive(Chassis driveTrain)
	{
		requires(driveTrain);
		this.driveTrain = driveTrain;
	}

	@Override
	public void execute()
	{
		driveTrain.drive();
	}

	@Override
	protected boolean isFinished()
	{
		return false;
	}
}
