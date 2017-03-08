package org.usfirst.frc.team3323.robot.Chassis;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Chassis extends Subsystem {
	private SpeedController driveMotorLeft = new Spark(4);
	private SpeedController driveMotorRight = new Spark(5);
	private Joystick joystickLeft;
	private Joystick joystickRight;
	private RobotDrive driveTrain;
	private boolean flipped;
	private PowerDistributionPanel powerBoard;
	
	public Chassis(Joystick joystickLeft, Joystick joystickRight, PowerDistributionPanel powerBoard)
	{
		this.joystickRight = joystickRight;
		this.joystickLeft = joystickLeft;
		driveTrain = new RobotDrive(driveMotorLeft, driveMotorRight);
		this.powerBoard = powerBoard;
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
		SmartDashboard.putString( "Drivetrain State","Gear");
	}

	public void regularDrive()
	{
		flipped=false;
		SmartDashboard.putString( "Drivetrain State","Normal");
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
	
	public RobotDrive getRobotDrive()
	{
	 return driveTrain;	
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
	
	public void info()
	{
		SmartDashboard.putNumber("Drive Left", powerBoard.getCurrent(12));
		SmartDashboard.putNumber("Drive Right", powerBoard.getCurrent(13));
		SmartDashboard.putNumber("PowerBoardTemp", (powerBoard.getTemperature()*1.8)+32);
		SmartDashboard.putNumber("PowerBoardVoltage", powerBoard.getVoltage());
	}
}
