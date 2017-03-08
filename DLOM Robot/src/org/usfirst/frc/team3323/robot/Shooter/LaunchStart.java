package org.usfirst.frc.team3323.robot.Shooter;

import edu.wpi.first.wpilibj.command.Command;

public class LaunchStart extends Command
{
	private Launch launch;
	
	public LaunchStart( Launch launcher )
	{
		requires(launcher);
		this.launch = launcher;
	}
	
	public void execute()
	{
		launch.launchStart();
	}
	
	public void end()
	{
		launch.launchStop();
	}
	
	protected boolean isFinished()
	{
		return false;
	}
}
