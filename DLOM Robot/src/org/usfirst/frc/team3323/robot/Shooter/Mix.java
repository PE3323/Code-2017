package org.usfirst.frc.team3323.robot.Shooter;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Mix extends Subsystem {

	private SpeedController mixerMotor = new Spark(6);
	private PowerDistributionPanel powerBoard;
	
	public Mix(PowerDistributionPanel powerBoard)
	{
		this.powerBoard = powerBoard;
	}

	public void initDefaultCommand()
	{
		setDefaultCommand(null);
    }
	
	public MixStart getMixStart()
	{
		return new MixStart(this);
	}
	
	public void mixStart()
	{
		mixerMotor.set(-.75);
	}

	public void mixStop()
	{
		mixerMotor.set(0);
	}
	
	public void info()
	{
		SmartDashboard.putNumber("Mixer", powerBoard.getCurrent(14));
	}
}

