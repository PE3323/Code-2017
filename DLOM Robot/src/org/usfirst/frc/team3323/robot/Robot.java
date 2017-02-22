package org.usfirst.frc.team3323.robot;


import org.opencv.core.Mat;
import org.usfirst.frc.team3323.robot.Drivetrain.Drivetrain;
import org.usfirst.frc.team3323.robot.FuelPickup.FuelPickup;
import org.usfirst.frc.team3323.robot.Launcher.Launcher;
import org.usfirst.frc.team3323.robot.Winch.Winch;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	private Joystick joystickLeft = new Joystick(1);
	private Joystick joystickRight = new Joystick(0);
	
	//Subsystems
	private Winch winch = new Winch();
	private FuelPickup fuelPickup = new FuelPickup();
	private Launcher launcher = new Launcher(joystickRight);
	private Drivetrain driveBase = new Drivetrain(joystickLeft, joystickRight);
	private Controls controls = new Controls(winch, fuelPickup, launcher, driveBase, joystickRight, joystickLeft);
	
	private PowerDistributionPanel powerBoard = new PowerDistributionPanel();

	@Override
	public void robotInit() {
		
		winch.init();
		fuelPickup.init();
		controls.init();
		UsbCamera robotCam = CameraServer.getInstance().startAutomaticCapture();
		UsbCamera gearCam = CameraServer.getInstance().startAutomaticCapture();
		robotCam.setResolution(640, 480);
		gearCam.setResolution(640, 480);
		SmartDashboard.putData(Scheduler.getInstance());
	}
	
	@Override
	public void robotPeriodic() {
		
		SmartDashboard.putNumber("PowerBoardTemp", (powerBoard.getTemperature()*1.8)+32);
		SmartDashboard.putNumber("PowerBoardVoltage", powerBoard.getVoltage());
		SmartDashboard.putNumber("Drive Left", powerBoard.getCurrent(12));
		SmartDashboard.putNumber("Shooter", powerBoard.getCurrent(0));
		SmartDashboard.putNumber("Drive Right", powerBoard.getCurrent(13));
		SmartDashboard.putNumber("Feeder", powerBoard.getCurrent(1));
		SmartDashboard.putNumber("Winch Right", powerBoard.getCurrent(3));
		SmartDashboard.putNumber("Winch Left", powerBoard.getCurrent(2));
		SmartDashboard.putNumber("Fuel Pickup", powerBoard.getCurrent(15));
		SmartDashboard.putNumber("Mixer", powerBoard.getCurrent(14));
	}
	
	@Override
	public void autonomousInit() {
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
//			driveBase.tankDrive(speed, curve);
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
			executePhase(500, .5, 0 );
		else if( phase == 1 )
			executePhase(750, .5, 1 );
		else if( phase == 2 )
			executePhase(500, .5, 0 );
		else if( phase == 3 )
			executePhase(750, .5, 1);
		else if( phase == 4 )
			executePhase(500, .5, 0 );
		else if( phase == 5 )
			executePhase(750, .5, 1);
		else if( phase == 6 )
			executePhase(500, .5, 0);
		else if( phase == 7 )
			executePhase(750, .5, 1);
		else if( phase == 8 )
			executePhase(500, .5, 0 );
		else if( phase == 9 )
			executePhase(750, .5, 1 );
		else if( phase == 10 )
			executePhase(500, .5, 0);
		else if( phase == 11 )
			executePhase(750, .5, -1 );
		else if( phase == 12 )
			executePhase(500, .5, 0);
		else if( phase == 13 )
			executePhase(750, .5, -1);
		else if( phase == 14 )
			executePhase(500, .5, 0);
		else if( phase == 15 )
			executePhase(750,.5,-1);
		else if( phase == 16 )
			executePhase(500, .5, 0);
		else if( phase == 17 )
			executePhase(750, .5, -1);
		else if( phase == 18 )
			executePhase(500, .5, 0);
		else if( phase == 19 )
			executePhase(750,.5,-1);
		else if( phase == 20 )
			executePhase(500, .5, 0);
		else 
			executePhase(0, 0, 0);
	}

	public void disabledPeriodic()
	{
		startTime = 0;
		phase = 0;
	}
	
	@Override
	public void teleopPeriodic()
	{		
		
		Scheduler.getInstance().run();
	}
	 public void track()
	 {
		CvSink imageSink = CameraServer.getInstance().getVideo();
		CvSource outputStream = CameraServer.getInstance().putVideo("Tracked", 640, 480);
		Mat input = new Mat();
		Mat output = new Mat();
		imageSink.grabFrame(input);	
		input.copyTo(output);
		outputStream.putFrame(output);
	 }
}

