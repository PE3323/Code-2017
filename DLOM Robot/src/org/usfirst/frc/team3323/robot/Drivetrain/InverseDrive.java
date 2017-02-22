package org.usfirst.frc.team3323.robot.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

public class InverseDrive extends Command
{
	private Drivetrain drivetrain;
	
	public InverseDrive(Drivetrain drivetrain)
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
		drivetrain.inverseDrive();
	}
}