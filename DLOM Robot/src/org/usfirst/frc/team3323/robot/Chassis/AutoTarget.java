package org.usfirst.frc.team3323.robot.Chassis;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoTarget extends CommandGroup
{
	public AutoTarget(Chassis drivetrain)
	{
		addSequential(new FaceBoiler());
	}

}
