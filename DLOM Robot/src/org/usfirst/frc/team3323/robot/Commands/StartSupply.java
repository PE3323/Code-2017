package org.usfirst.frc.team3323.robot.Commands;

import org.usfirst.frc.team3323.robot.Subsystems.Launcher;

import edu.wpi.first.wpilibj.command.Command;

public class StartSupply extends Command {

	private Launcher launcher;
	
	public StartSupply(Launcher launcher)
	{
		requires(launcher);
		this.launcher = launcher;
	}
	protected void execute() 
	{
	launcher.shoot();
	}
	
	@Override
	protected boolean isFinished()
	{
		return false;
	}
}
