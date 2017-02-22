package org.usfirst.frc.team3323.robot;

import org.usfirst.frc.team3323.robot.Drivetrain.Drivetrain;
import org.usfirst.frc.team3323.robot.FuelPickup.FuelPickup;
import org.usfirst.frc.team3323.robot.Launcher.Launcher;
import org.usfirst.frc.team3323.robot.Winch.Winch;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class Controls {
	
	public Controls(Winch winch,FuelPickup fuelPickup,Launcher launcher, Drivetrain drivetrain,Joystick joystickRight,Joystick joystickLeft)
	{
	Button winchWindSwitch = new JoystickButton(joystickRight,5);
	Button fuelPickupSwitch = new JoystickButton(joystickRight,2);
	Button launchSwitch = new JoystickButton(joystickLeft, 1);
	Button normalDriveSwitch = new JoystickButton(joystickRight, 3);
	Button inverseDriveSwitch = new JoystickButton(joystickLeft, 3);
	Button rickSwitch = new JoystickButton(joystickRight, 1);
	Button selfDestruct = new JoystickButton(joystickRight, 8);
	Button mixSwitch = new JoystickButton(joystickLeft, 2);
//	Button autoTargetStart = new JoystickButton(joystickLeft, 6);
	
	
	winchWindSwitch.whileHeld(winch.getWinchWindUp()); 
	fuelPickupSwitch.toggleWhenPressed(fuelPickup.getStartPickup());
	rickSwitch.toggleWhenPressed(launcher.getStartSupply());
	normalDriveSwitch.whenPressed(drivetrain.getRegularDrive());
	inverseDriveSwitch.whenPressed(drivetrain.getInverseDrive());
	launchSwitch.toggleWhenPressed(launcher.getLauncherStart());
	selfDestruct.toggleWhenPressed(drivetrain.getGoBoom());
	mixSwitch.whileHeld(launcher.getMix());
//	autoTargetStart.toggleWhenPressed();
	
//	autoTargetStart.whileHeld(drivetrain.getAutoTarget());
	}
	
	public void init()
	{
		
	}
	
}
