package org.usfirst.frc.team3323.robot.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

public class GoBoom extends Command {
	private Drivetrain drivetrain;
	
	public GoBoom( Drivetrain drivetrain )
	{
		requires(drivetrain);
		this.drivetrain = drivetrain;
	}
	
	@Override
	protected boolean isFinished()
	{
		return false;
	}
	protected void execute()
	{
		drivetrain.boom();
	}
}