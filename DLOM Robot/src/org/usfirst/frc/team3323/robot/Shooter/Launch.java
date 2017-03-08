package org.usfirst.frc.team3323.robot.Shooter;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Launch extends Subsystem {

	private SpeedController launcherMotor = new Spark(1);
	private PowerDistributionPanel powerBoard;
	private Joystick joystickRight;
	
	public Launch(PowerDistributionPanel powerBoard, Joystick joystickRight)
	{
		this.powerBoard = powerBoard;
		this.joystickRight = joystickRight;
	}
	
    public void initDefaultCommand()
	{
		setDefaultCommand(null);
    }
	
	public LaunchStart getLauncherStart()
	{
		return new LaunchStart(this);
	}
	
	public void launchStart()
	{
		launcherMotor.set((-joystickRight.getAxis(AxisType.kZ)+1)/2);
		SmartDashboard.putString( "Shooter State","On");
	}
	
	public void launchStop()
	{
		launcherMotor.set(0);
		SmartDashboard.putString( "Shooter State","Off");
	}
	
	public void info()
	{
		SmartDashboard.putNumber("Launcher", powerBoard.getCurrent(0));
	}
}

