package org.usfirst.frc.team3323.robot;


import org.usfirst.frc.team3323.robot.Commands.TestDrive;
import org.usfirst.frc.team3323.robot.Subsystems.FuelPickup;
import org.usfirst.frc.team3323.robot.Subsystems.Launcher;
import org.usfirst.frc.team3323.robot.Subsystems.Winch;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	
	private Joystick joystickRight = new Joystick(1);
	private Joystick joystickLeft = new Joystick(0);
	
	//Subsystems
	private Winch winch = new Winch();
	private FuelPickup fuelPickup = new FuelPickup();
	private Launcher launcher = new Launcher(joystickRight);
	
	//Tank Drive
	private SpeedController driveMotorLeft = new Spark(1);
	private SpeedController driveMotorRight = new Spark(2);
	private RobotDrive driveTrain = new RobotDrive(driveMotorRight, driveMotorLeft);
	
	//DashBoard
	private PowerDistributionPanel powerBoard = new PowerDistributionPanel();
	
	//Buttons
	private Button winchWindSwitch = new JoystickButton(joystickRight,5);
	private Button winchUnWindSwitch = new JoystickButton(joystickRight,4);
	private Button fuelPickupSwitch = new JoystickButton(joystickRight,2);
	private Button launcherSupplySwitch = new JoystickButton(joystickRight, 1);
	private Button fuelPickupDirectionSwitch = new JoystickButton(joystickRight, 3);
	
	//Commands
	private TestDrive testDrive = new TestDrive(driveMotorLeft, driveMotorLeft);

	@Override
	public void robotInit() {
		
		
		driveTrain.tankDrive(joystickRight,joystickLeft);
		winchWindSwitch.whileHeld(winch.getWinchWindUp());
		winchUnWindSwitch.whileHeld(winch.getWinchUnWind()); 
		fuelPickupSwitch.toggleWhenPressed(fuelPickup.getStartPickup());
		fuelPickupDirectionSwitch.whenPressed(fuelPickup.getPickupDirectionToggle());
		launcherSupplySwitch.whileHeld(launcher.getStartSupply());
		SmartDashboard.putData("Drivetrain Test", testDrive); 
		SmartDashboard.putData(Scheduler.getInstance());
		UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
		camera.setResolution(800, 800);	
		
	}
	
	@Override
	public void robotPeriodic() {
		
		SmartDashboard.putNumber("PowerBoardTemp", powerBoard.getTemperature());
		SmartDashboard.putNumber("PowerBoardVoltage", powerBoard.getVoltage());
		SmartDashboard.putNumber("DriveMotorLCurrent", powerBoard.getCurrent(1));
		SmartDashboard.putNumber("ShooterMotorCurrent", powerBoard.getCurrent(2));
		SmartDashboard.putNumber("DriveMotorRCurrent", powerBoard.getCurrent(3));
	}
	
	@Override
	public void autonomousInit() {
		System.out.println("Github is the essence of pure evil");
		startTime = 0;
		phase = 0;
	}

	
	private int phase = 0;
	private long startTime = 0;
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		if( startTime == 0 )
			startTime = System.currentTimeMillis();
		
		if( phase == 0 )
		{
			if( System.currentTimeMillis() - startTime < 250 )
			{
				driveTrain.drive(.5, 0);
			}
			else 
			{
				phase = 1;
				startTime = System.currentTimeMillis();
			}
		}		
		else if( phase == 1 )
		{
			if( System.currentTimeMillis() - startTime < 500 )
			{
				driveTrain.drive(.5, 1);
			}	
			else 
			{
				phase = 2;
				startTime = System.currentTimeMillis();
			}
		}
		else if( phase == 2 )
		{
			if( System.currentTimeMillis() - startTime < 250 )
			{
				driveTrain.drive(.5, 0);
			}
			else 
			{
				phase = 3;
				startTime = System.currentTimeMillis();
			}
		}	
		else
		{
			phase = 0;
		}
	
		
		
	}

	public void disabledPeriodic()
	{
		startTime = 0;
		phase = 0;
	}
	
	@Override
	public void teleopPeriodic() {		
		
		Scheduler.getInstance().run();
		driveTrain.tankDrive(joystickLeft,joystickRight);	
	}
}

