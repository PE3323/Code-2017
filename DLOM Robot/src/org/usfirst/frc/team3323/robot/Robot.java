package org.usfirst.frc.team3323.robot;

import org.usfirst.frc.team3323.robot.Chassis.Chassis;
import org.usfirst.frc.team3323.robot.FuelPickup.FuelPickup;
import org.usfirst.frc.team3323.robot.Shooter.Launch;
import org.usfirst.frc.team3323.robot.Shooter.Mix;
import org.usfirst.frc.team3323.robot.Shooter.Supply;
import org.usfirst.frc.team3323.robot.Winch.Winch;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot
{
	private Joystick joystictLeft = new Joystick(0);
	private Joystick joystickRight = new Joystick(1);
	private PowerDistributionPanel powerBoard = new PowerDistributionPanel();
	private Winch winch = new Winch(powerBoard);
	private FuelPickup fuelPickup = new FuelPickup(powerBoard);
	private Launch launcher = new Launch(powerBoard, joystickRight);
	private Chassis chassis = new Chassis(joystickRight, joystictLeft, powerBoard);
	private Mix mix = new Mix(powerBoard);
	private Supply supply = new Supply(powerBoard);
	private Controls controls = new Controls(winch, fuelPickup, launcher, supply, mix, chassis, joystictLeft, joystickRight);
	private UsbCamera robotCam = CameraServer.getInstance().startAutomaticCapture();
	private UsbCamera gearCam = CameraServer.getInstance().startAutomaticCapture();

	public void robotInit()
	{
		robotCam.setResolution(640, 480);
		gearCam.setResolution(640, 480);
		SmartDashboard.putData(Scheduler.getInstance());
	}
	
	public void robotPeriodic()
	{
		controls.log();
		chassis.drive();
	}
	
	public void autonomousInit()
	{
		System.out.println("Github is the essence of pure evil");
		startTime = 0;
		phase = 0;
	}

	
	private int phase = 0;
	private long startTime = 0;
	private int executePhase( long duration, double speed, double curve )
	{
		long dur = System.currentTimeMillis() - startTime;
		System.out.println("Phases" + phase + ":" + dur);
		if( dur < duration )
		{
			chassis.getRobotDrive().drive(speed, curve);
			SmartDashboard.putString("Auto State","Running");
		}
		else 
		{
			phase++;
			startTime = System.currentTimeMillis();
			System.out.println("new phase:" + phase );
		}
		
		return phase;
	}
	
	public void autonomousPeriodic()
	{
		Scheduler.getInstance().run();
		
		if( startTime == 0 )
			startTime = System.currentTimeMillis();

		if( phase == 0 )
			executePhase(2000, -1, 0 );
		else 
			executePhase(0, 0, 0);
	}

	public void disabledPeriodic()
	{
		startTime = 0;
		phase = 0;
	}
	
	public void teleopPeriodic()
	{		
		Scheduler.getInstance().run();
	}
	
	public void teleopInit()
	{		
		SmartDashboard.putString("Robot State","All Good");
	}
	
	
	public void track()
	{
	}
}

