package org.usfirst.frc.team3323.robot.Commands;

import org.usfirst.frc.team3323.robot.Subsystems.Winch;

import edu.wpi.first.wpilibj.command.Command;

public class WinchStop extends Command{
	private Winch winch;
	
	public WinchStop( Winch winch )
	{
		requires(winch);
		this.winch = winch;
	}
	
	@Override
	protected boolean isFinished()
	{
		return false;
	}
	protected void execute()
	{
		winch.stop();
	}
   
}
