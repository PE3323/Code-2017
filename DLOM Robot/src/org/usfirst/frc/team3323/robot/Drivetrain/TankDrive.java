package org.usfirst.frc.team3323.robot.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TankDrive extends Command
{
	private Drivetrain driveTrain;
	
	public TankDrive(Drivetrain driveTrain)
	{
		requires(driveTrain);
		this.driveTrain = driveTrain;
	}

	@Override
	public void execute()
	{
		driveTrain.drive();
		SmartDashboard.putString("Robot State","OK");
	}

	@Override
	protected boolean isFinished()
	{
		return false;
	}
}
