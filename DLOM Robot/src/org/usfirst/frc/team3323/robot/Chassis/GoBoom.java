package org.usfirst.frc.team3323.robot.Chassis;

import edu.wpi.first.wpilibj.command.Command;

public class GoBoom extends Command
{
	private Chassis drivetrain;
	
	public GoBoom( Chassis drivetrain )
	{
		requires(drivetrain);
		this.drivetrain = drivetrain;
	}
	
	protected boolean isFinished()
	{
		return false;
	}
	
	public void execute()
	{
		drivetrain.boom();
	}
}