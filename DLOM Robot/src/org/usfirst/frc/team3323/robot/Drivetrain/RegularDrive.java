package org.usfirst.frc.team3323.robot.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

public class RegularDrive extends Command
{
	private Drivetrain drivetrain;
	
	public RegularDrive(Drivetrain drivetrain)
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