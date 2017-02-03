package org.usfirst.frc.team3323.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.RobotDrive;
//import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	
	//Tank Drive
	private SpeedController driveMotorLeft = new Spark(1);
	private SpeedController driveMotorRight = new Spark(2);
	private RobotDrive robotDrive = new RobotDrive(driveMotorLeft, driveMotorRight);
	
	//Fuel System
	private SpeedController launcherMotor = new Spark(3);
	private SpeedController launcherSupplyMotor = new Spark(5);
	private SpeedController fuelPickupMotor = new Spark(4);
	private FuelPickup fuelPickup = new FuelPickup(fuelPickupMotor);
	
	//Winch
	private SpeedController winchMotorLeft = new Talon(7);
	private SpeedController winchMotorRight = new Talon(6);
	
	//Joy Stick
	private Joystick joystickRight = new Joystick(1);
	private Joystick joystickLeft = new Joystick(0);
	
	//DashBoard
	private PowerDistributionPanel powerBoard = new PowerDistributionPanel();
	
	//Buttons
	private Button winchWindSwitch = new JoystickButton(joystickRight,5);
	private Button winchUnWindSwitch = new JoystickButton(joystickRight,4);
	private Button fuelPickupSwitch = new JoystickButton(joystickRight,2);
	private Button launcherSupplySwitch = new JoystickButton(joystickRight, 1);
	private Button fuelPickupDirectionSwitch = new JoystickButton(joystickRight, 3);
	
	
	
	
	//Commands
	private WinchWindUp  winchWindUp = new WinchWindUp(winchMotorLeft,winchMotorRight);
	private WinchUnWind  winchUnWind = new WinchUnWind(winchMotorLeft,winchMotorRight);
	private StartPickup  fuelPickupOn = new StartPickup(fuelPickup);
	private LauncherSupply  launcherSupply = new LauncherSupply(launcherSupplyMotor);
	private PickupDirectionToggle  fuelPickupDirection = new PickupDirectionToggle(fuelPickup);
	private TestDrive testDrive = new TestDrive(driveMotorLeft,driveMotorRight);
	

	
	
	@Override
	public void robotInit() {
		
		winchMotorLeft.set(0);
		winchMotorRight.set(0);		
		robotDrive.tankDrive(joystickLeft,joystickRight);
		winchWindSwitch.whileHeld(winchWindUp);
		winchUnWindSwitch.whileHeld(winchUnWind); 
		fuelPickupSwitch.toggleWhenPressed(fuelPickupOn);
		fuelPickupDirectionSwitch.whenPressed(fuelPickupDirection);
		launcherSupplySwitch.whileHeld(launcherSupply);
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
		SmartDashboard.putNumber("Launcher Double",(launcherMotor.get()));
	}
	
	@Override
	public void autonomousInit() {
		System.out.println("Github is the essence of pure evil");
	}

	@Override
	public void autonomousPeriodic() {
	}

	@Override
	public void teleopPeriodic() {		
		
		Scheduler.getInstance().run();
		robotDrive.tankDrive(joystickLeft,joystickRight);
		launcherMotor.set((-joystickRight.getAxis(AxisType.kZ)+1)/2);
		
	}

	
	@Override
	public void teleopInit() {
		winchMotorLeft.set(0);
		winchMotorRight.set(0);
	}
}

