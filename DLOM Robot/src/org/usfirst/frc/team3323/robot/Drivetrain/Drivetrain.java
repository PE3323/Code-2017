package org.usfirst.frc.team3323.robot.Drivetrain;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drivetrain extends Subsystem {
	private SpeedController driveMotorLeft = new Spark(4);
	private SpeedController driveMotorRight = new Spark(5);
	private Joystick joystickLeft;
	private Joystick joystickRight;
	RobotDrive driveTrain;
	private boolean flipped;
	
	public Drivetrain(Joystick joystickLeft, Joystick joystickRight)
	{
		this.joystickRight = joystickRight;
		this.joystickLeft = joystickLeft;
		driveTrain = new RobotDrive(driveMotorLeft, driveMotorRight);
	}

	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new TankDrive(this));
	}
	
	public void drive()
	{
		if (flipped==true)
			{
			double leftMotorSpeed = -joystickLeft.getAxis(AxisType.kY);
			double rightMotorSpeed = -joystickRight.getAxis(AxisType.kY);
			driveTrain.tankDrive(leftMotorSpeed,rightMotorSpeed);
			}
		else
			driveTrain.tankDrive(joystickRight, joystickLeft);
	}
	
	public void inverseDrive()
	{
		flipped=true;
	}

	public void regularDrive()
	{
		flipped=false;
	}
	
	public TankDrive getTankDrive()
	{
		return new TankDrive(this);
	}
	
	public InverseDrive getInverseDrive()
	{
		return new InverseDrive(this);
	}
	
	public RegularDrive getRegularDrive()
	{
		return new RegularDrive(this);
	}


	public void stop()
	{
		driveTrain.drive(0, 0);
	}
	
	public void boom()
	{
		SmartDashboard.putString("Robot State","BOOOOOOMMM");
	}
	
	public GoBoom getGoBoom()
	{
		return new GoBoom(this);
	}
}
