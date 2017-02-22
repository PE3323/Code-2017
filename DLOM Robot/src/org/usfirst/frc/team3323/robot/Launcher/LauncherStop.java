package org.usfirst.frc.team3323.robot.Launcher;

import edu.wpi.first.wpilibj.command.Command;

public class LauncherStop extends Command {

	private Launcher launcher;
	
	public LauncherStop(Launcher launcher)
	{
		requires(launcher);
		this.launcher = launcher;
	}
	
	public void execute() 
	{
	launcher.supplyStop();
	launcher.launchStop();
	launcher.mixStop();
	}
	
	@Override
	protected boolean isFinished()
	{
		return false;
	}
}