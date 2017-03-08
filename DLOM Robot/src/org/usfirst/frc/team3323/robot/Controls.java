package org.usfirst.frc.team3323.robot;

import org.usfirst.frc.team3323.robot.Chassis.Chassis;
import org.usfirst.frc.team3323.robot.FuelPickup.FuelPickup;
import org.usfirst.frc.team3323.robot.Shooter.Launch;
import org.usfirst.frc.team3323.robot.Shooter.Mix;
import org.usfirst.frc.team3323.robot.Shooter.Supply;
import org.usfirst.frc.team3323.robot.Winch.Winch;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class Controls {
	
	private Winch winch;
	private FuelPickup fuelPickup;
	private Chassis drivetrain;
	private Launch launch;
	private Supply supply;
	private Mix mix;
	
	public Controls(Winch winch, FuelPickup fuelPickup, Launch launch, Supply supply, Mix mix, Chassis drivetrain,Joystick joystickRight,Joystick joystickLeft)
	{
		this.winch = winch;
		this.fuelPickup = fuelPickup;
		this.drivetrain = drivetrain;
		this.launch = launch;
		this.supply = supply;
		this.mix = mix;
		
	Button winchWindSwitch = new JoystickButton(joystickRight,5);
	Button fuelPickupSwitch = new JoystickButton(joystickRight,2);
	Button normalDriveSwitch = new JoystickButton(joystickRight, 3);
	Button supplySwitch = new JoystickButton(joystickRight, 1);
	Button selfDestruct = new JoystickButton(joystickRight, 8);
	Button inverseDriveSwitch = new JoystickButton(joystickLeft, 3);
	Button launchSwitch = new JoystickButton(joystickLeft, 1);
	Button mixSwitch = new JoystickButton(joystickLeft, 2);
//	Button turnRight = new JoystickButton(joystickLeft, 9);
//	Button turnLeft = new JoystickButton(joystickLeft, 8);
//	Button moveForward = new JoystickButton(joystickLeft, 7);
//	Button moveBack = new JoystickButton(joystickLeft, 6);
	
//	Button autoTargetStart = new JoystickButton(joystickLeft, 6);
	
	
	winchWindSwitch.whileHeld(winch.getWinchWindUp()); 
	fuelPickupSwitch.toggleWhenPressed(fuelPickup.getStartPickup());
	supplySwitch.whileHeld(supply.getStartSupply());
	normalDriveSwitch.whenPressed(drivetrain.getRegularDrive());
	inverseDriveSwitch.whenPressed(drivetrain.getInverseDrive());
	launchSwitch.toggleWhenPressed(launch.getLauncherStart());
	selfDestruct.toggleWhenPressed(drivetrain.getGoBoom());
	mixSwitch.whileHeld(mix.getMixStart());
//	autoTargetStart.whileHeld(drivetrain.getAutoTarget());
	}
	public void log()
	{
	winch.info();
	fuelPickup.info();
	launch.info();
	drivetrain.info();
	supply.info();
	mix.info();
		
	}
}
