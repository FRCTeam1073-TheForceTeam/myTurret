// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc1073.myTurret;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Servo;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	public static Servo panny;
    public static Servo tilty;
    public static DigitalInput leftLimit;
    public static DigitalInput rightLimit;
    public static DigitalInput lowerLimit;
    public static DigitalInput upperLimit;
    
    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    	Servo panny = new Servo(0);
        LiveWindow.addActuator("DriveTrain", "panny", panny);
        
        Servo tilty = new Servo(1);
        LiveWindow.addActuator("DriveTrain", "tilty", tilty);
        
        leftLimit = new DigitalInput(1);
        LiveWindow.addSensor("DriveLimits", "leftLimit", leftLimit);
        
        leftLimit = new DigitalInput(2);
        LiveWindow.addSensor("DriveLimits", "rightLimit", rightLimit);
        
        leftLimit = new DigitalInput(3);
        LiveWindow.addSensor("DriveLimits", "lowerLimit", lowerLimit);
        
        leftLimit = new DigitalInput(4);
        LiveWindow.addSensor("DriveLimits", "upperLimit", upperLimit);
        
    }
}
