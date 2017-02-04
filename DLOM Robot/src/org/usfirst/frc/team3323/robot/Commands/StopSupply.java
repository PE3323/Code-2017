package org.usfirst.frc.team3323.robot.Commands;

import org.usfirst.frc.team3323.robot.Subsystems.Launcher;

import edu.wpi.first.wpilibj.command.Command;

public class StopSupply extends Command {
	
	private Launcher launcher;
	
	public StopSupply(Launcher launcher)
	{
		requires(launcher);
		this.launcher = launcher;
	}
	protected void execute()
	{
	launcher.off();
	}
	
	@Override
	protected boolean isFinished()
	{
		return false;
	}
}
