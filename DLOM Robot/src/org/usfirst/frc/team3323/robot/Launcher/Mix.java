package org.usfirst.frc.team3323.robot.Launcher;

import edu.wpi.first.wpilibj.command.Command;

public class Mix extends Command
{
	private Launcher launcher;
	
	public Mix( Launcher launcher )
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
		launcher.mixStart();
	}
	
	public void end()
	{
		launcher.mixStop();
	}   
}
