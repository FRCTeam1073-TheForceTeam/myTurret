package org.usfirst.frc1073.myTurret;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static Servo panny;
    public static Servo tilty;
    
    public static boolean leftLimit; // Impromptu "limit switches" based off of the angle of the servos
    public static boolean rightLimit; 
    public static boolean lowerLimit;
    public static boolean upperLimit;
    
    public static double low; // Limit values
    public static double high;
    
    public static void init() {
    	
    	// Servo limit value initialization
    	low = .1;
    	high = .9;
    	
    	Servo panny = new Servo(0);
        LiveWindow.addActuator("DriveTrain", "panny", panny);
        
        Servo tilty = new Servo(1);
        LiveWindow.addActuator("DriveTrain", "tilty", tilty);
        
        
    }
}
