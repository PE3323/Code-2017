package org.usfirst.frc.team3323.robot.Shooter;

import edu.wpi.first.wpilibj.command.Command;

public class MixStart extends Command
{
	private Mix mix;
	
	public MixStart( Mix mix )
	{
		requires(mix);
		this.mix = mix;
	}
	
	public void execute()
	{
		mix.mixStart();
	}

	public void end()
	{
		mix.mixStop();
	}
	
	protected boolean isFinished()
	{
		return false;
	}
}
