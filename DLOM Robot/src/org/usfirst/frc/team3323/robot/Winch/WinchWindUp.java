package org.usfirst.frc.team3323.robot.Winch;

import edu.wpi.first.wpilibj.command.Command;

public class WinchWindUp extends Command {
	private Winch winch;
	
	public WinchWindUp( Winch winch )
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
		winch.up();
	}
	protected void end() 
	{
		winch.stop();
	}
}