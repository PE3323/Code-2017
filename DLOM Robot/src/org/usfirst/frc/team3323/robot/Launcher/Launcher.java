package org.usfirst.frc.team3323.robot.Launcher;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Launcher extends Subsystem {

	private SpeedController launcherMotor = new Spark(1);
	private SpeedController supplyMotor = new Spark(0);
	private SpeedController mixerMotor = new Spark(6);
	private Joystick joystickRight;
	
	public Launcher(Joystick joystickRight)
	{
		this.joystickRight = joystickRight;
	}
	
	@Override
    public void initDefaultCommand()
	{
		setDefaultCommand(new LauncherStop(this));
    }
	
	public LauncherStart getLauncherStart()
	{
		return new LauncherStart(this);
	}
	
	public StartSupply getStartSupply()
	{
		return new StartSupply(this);
	}
	
	public Mix getMix()
	{
		return new Mix(this);
	}
	
	public void supplyStart()
	{
		supplyMotor.set(.5);
	}
	
	public void supplyStop()
	{
		supplyMotor.set(0);
	}
	
	public void launchStart()
	{
		launcherMotor.set((-joystickRight.getAxis(AxisType.kZ)+1)/2);
	}
	
	public void launchStop()
	{
		launcherMotor.set(0);
	}
	
	public void mixStart()
	{
		mixerMotor.set(-.75);
	}

	public void mixStop()
	{
		mixerMotor.set(0);
	}
}

