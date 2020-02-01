/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

import static frc.robot.Constants.MotorPorts.*;

public class DriveTrain extends SubsystemBase {
  /**
   * Creates a new DriveTrain.
   */

  VictorSP left;
  VictorSP right;

  DifferentialDrive drive;

  public DriveTrain() {
    left = new VictorSP(LEFT);
    right = new VictorSP(RIGHT);
    drive = new DifferentialDrive(left, right);
    drive.setMaxOutput(.8);    


  }
  
  public void drive(){
    drive.arcadeDrive(RobotContainer.getDriverThrottle(), -RobotContainer.getDriverAxis());
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
