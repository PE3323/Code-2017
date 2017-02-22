package org.usfirst.frc.team3323.robot.Launcher;

import edu.wpi.first.wpilibj.command.Command;

public class LauncherStart extends Command
{
	private Launcher launcher;
	
	public LauncherStart( Launcher launcher )
	{
		requires(launcher);
		this.launcher = launcher;
	}
	
	@Override
	protected boolean isFinished()
	{
		return false;
	}
	public void execute()
	{
		launcher.launchStart();
	}
	
	public void end()
	{
		launcher.launchStop();
	}
	

   
}
