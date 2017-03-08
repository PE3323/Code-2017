package org.usfirst.frc.team3323.robot.Chassis;

import edu.wpi.first.wpilibj.command.Command;

public class RegularDrive extends Command
{
	private Chassis drivetrain;
	
	public RegularDrive(Chassis drivetrain)
	{
		requires(drivetrain);
		this.drivetrain= drivetrain;
	}
	
	@Override
	protected boolean isFinished()
	{
		return true;
	}
	protected void execute()
	{
		drivetrain.regularDrive();
	}
}