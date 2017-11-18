package org.usfirst.frc1073.myTurret.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc1073.myTurret.Robot;
import org.usfirst.frc1073.myTurret.RobotMap;
import org.usfirst.frc1073.myTurret.OI;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/** Auto command for myTurret:
 *	
 *	Seeks a designated target and tracks it when found.
 *	
 *	By Nathaniel and Myles!
 *	Featuring panny and tilty!
 *	Sponsered by Lays! "Stay Wavy"
 */
public class AutonomousCommand extends Command {

	NetworkTable netTable;
	double xDelta;
	double xWidth;
	double yDelta;
	double yWidth;
	double blockCount;
	
	int hScanDir;
	int vScanDir;

	public AutonomousCommand() {
		netTable = NetworkTable.getTable("TurretTable");
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		hScanDir = -1;
		vScanDir = 1;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	// Pulls variables from Network Tables
		xDelta =  netTable.getNumber("centerDistX", 0);
		xWidth =  netTable.getNumber("AverageWidth", 0);
		yDelta =  netTable.getNumber("centerDistY", 0);
		yWidth =  netTable.getNumber("AverageHeight", 0);
		blockCount = netTable.getNumber("Blocks", 0);
	
	// Defines speed and slow down markers
		double rotationalSpeed = 0.2;
		double verticalSpeed = 0.1;
		double horizontalEndSpeed = 0;
		double verticalEndSpeed = 0;
		double side = 8; // Marks the reasonable area around the center	
		
	// Puts variables from Network Tables on SmartDashboard
		SmartDashboard.putNumber("xDelta", xDelta);
		SmartDashboard.putNumber("xWidth", xWidth);
		SmartDashboard.putNumber("yDelta", yDelta);
		SmartDashboard.putNumber("yWidth", yWidth);
		SmartDashboard.putNumber("Block Count", blockCount);

	// BLockCount asks the Pixy how many things it sees
	// When it sees something, we track it
		if (blockCount > 0) {
			SmartDashboard.putString("Current State", "Targeting (" + blockCount + ")");
			
	// Increases speed of the turrets rotation depending on 
	// how far the target is to the left or right
			if (Math.abs(xDelta) > side) {
				if (Math.abs(xDelta) > side + 5) {
					// Second fastest
					horizontalEndSpeed = 2 * rotationalSpeed;
				}
				if (Math.abs(xDelta) > side + 15){
					// Fastest speed
					horizontalEndSpeed = 3 * rotationalSpeed;
				}
				else {
					// Third fastest
					horizontalEndSpeed = rotationalSpeed;
				}
			}
			else {
				// Nothing changes
				horizontalEndSpeed = 0;
			}
			
	// This code handles the left and right motion of the turret
	// based on the Pixy's values
			if (xDelta > side) {
				horizontalEndSpeed = horizontalEndSpeed;
				SmartDashboard.putString("Target", "Right");
			}
			else if (xDelta < -side) {
				horizontalEndSpeed = -horizontalEndSpeed;
				SmartDashboard.putString("Target", "Left");
			}
			else {
				horizontalEndSpeed = 0;
				SmartDashboard.putString("Target", "Centered");
			}
			
	// This code sends the info to the panny
	// as long as it isn't hitting a limit switch.
			if (RobotMap.leftLimit.get() == false && RobotMap.rightLimit.get() == false) {
				RobotMap.panny.set(horizontalEndSpeed);
			}
			else if (RobotMap.leftLimit.get() == true && xDelta > 0) {
				RobotMap.panny.set(horizontalEndSpeed);
			}
			else if (RobotMap.rightLimit.get() == true && xDelta < 0) {
				RobotMap.panny.set(horizontalEndSpeed);
			}
			else {
				RobotMap.panny.set(0);
			}
			
	// Increases speed of the turrets vertical rotation depending on 
	// how far the target is to the left or right
			if (Math.abs(yDelta) > side) {
				if (Math.abs(yDelta) > side + 5) {
					// Second fastest
					verticalEndSpeed = 2 * verticalSpeed;
				}
				if (Math.abs(yDelta) > side + 15){
					// Fastest speed
					verticalEndSpeed = 3 * verticalSpeed;
				}
				else {
					// Third fastest
					verticalEndSpeed = verticalSpeed;
				}
			}
			else {
				// Nothing changes
				verticalEndSpeed = 0;
			}
			
	// This code handles the up and down motion of the turret
	// based on the Pixy's values
			if (yDelta > side) {
				verticalEndSpeed = verticalEndSpeed;
				SmartDashboard.putString("TargetVert", "Up");
			}
			else if (yDelta < -side) {
				verticalEndSpeed = -verticalEndSpeed;
				SmartDashboard.putString("TargetVert", "Down");
			}
			else {
				verticalEndSpeed = 0;
				SmartDashboard.putString("TargetVert", "Centered");
			}
			
	// This code sends the info to the tilty
	// as long as it isn't hitting a limit switch.
			if (RobotMap.lowerLimit.get() == false && RobotMap.upperLimit.get() == false) {
				RobotMap.tilty.set(verticalEndSpeed);
			}
			else if (RobotMap.lowerLimit.get() == true && yDelta > 0) {
				RobotMap.tilty.set(verticalEndSpeed);
			}
			else if (RobotMap.upperLimit.get() == true && yDelta < 0) {
				RobotMap.tilty.set(verticalEndSpeed);
			}
			else {
				RobotMap.tilty.set(0);
			}
		}
		
	// When no blocks are seen, we strafe back and forth, and up and down,
	// while the turret looks for the target.
		else {
			SmartDashboard.putString("Current State", "Searching (" + blockCount + ")");
			
			// Left and right
			if (RobotMap.leftLimit.get() == true) {
				RobotMap.panny.set(.2);
				hScanDir = 1;
			}
			else if (RobotMap.rightLimit.get() == true) {
				RobotMap.panny.set(-.2);
				hScanDir = -1;
			}
			else {
				RobotMap.panny.set(hScanDir * .2);
			}
			// Up and down
			if (RobotMap.upperLimit.get() == true) {
				RobotMap.tilty.set(-.1);
				vScanDir = -1;
			}
			else if (RobotMap.lowerLimit.get() == true) {
				RobotMap.tilty.set(.1);
				vScanDir = 1;
			}
			else {
				RobotMap.tilty.set(vScanDir * .1);
			}
		}
	
	// Puts the speeds of the motors on SmartDashboard
		SmartDashboard.putNumber("Vertical Speed", verticalEndSpeed);
		SmartDashboard.putNumber("Horizontal Speed", horizontalEndSpeed);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		RobotMap.panny.set(0);
		RobotMap.tilty.set(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		RobotMap.panny.set(0);
		RobotMap.tilty.set(0);
	}
}
