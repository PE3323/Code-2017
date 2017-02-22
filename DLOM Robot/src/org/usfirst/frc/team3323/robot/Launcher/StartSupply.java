package org.usfirst.frc.team3323.robot.Launcher;

import edu.wpi.first.wpilibj.command.Command;

public class StartSupply extends Command {

	private Launcher launcher;
	
	public StartSupply(Launcher launcher)
	{
		requires(launcher);
		this.launcher = launcher;
	}
	public void execute() 
	{
	launcher.supplyStart();
	}
	
	@Override
	protected boolean isFinished()
	{
		return false;
	}
	
	public void end() 
	{
	launcher.supplyStop();
	}
}
