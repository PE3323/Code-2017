package org.usfirst.frc.team3323.robot.Commands;

import org.usfirst.frc.team3323.robot.Subsystems.Winch;
import edu.wpi.first.wpilibj.command.Command;

public class WinchUnWind extends Command {
	private Winch winch;
	
	public WinchUnWind( Winch winch )
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
		winch.down();
	}
	protected void end() 
	{
		winch.stop();
	}
}
