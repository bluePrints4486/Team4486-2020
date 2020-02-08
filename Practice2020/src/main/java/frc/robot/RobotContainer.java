/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.Drive;
import frc.robot.commands.HopperForward;
import frc.robot.commands.HopperOff;
import frc.robot.commands.HopperReverse;
import frc.robot.commands.ShootHigh;
import frc.robot.commands.ShootLow;
import frc.robot.commands.ShootOff;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import static frc.robot.Constants.JoystickPorts.*;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  
  private final DriveTrain m_drivetrain = new DriveTrain();
  private final Hopper m_hopper = new Hopper();
  private final Shooter m_shooter = new Shooter();
 
  
  private final Drive m_drive = new Drive(m_drivetrain); 
  private final ShootHigh m_shootHigh = new ShootHigh(m_shooter);
  private final ShootLow m_shootLow = new ShootLow(m_shooter);
  private final ShootOff m_shootOff = new ShootOff(m_shooter);
  private final HopperForward m_hopperForward = new HopperForward(m_hopper);
  private final HopperReverse m_hopperReverse = new HopperReverse(m_hopper);
  private final HopperOff m_hopperOff = new HopperOff(m_hopper);

  private static Joystick driver ;
  private static Joystick throttle ;
  private static Joystick manipulator ;

  private static JoystickButton shootHighButton ;
  private static JoystickButton shootLowButton ;
  private static JoystickButton hopperForwardButton ;
  private static JoystickButton hopperReverseButton ;

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    setDefaults();
  }

  private void setDefaults(){
    m_drivetrain.setDefaultCommand(m_drive);
    m_shooter.setDefaultCommand(m_shootOff);
    m_hopper.setDefaultCommand(m_hopperOff);
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    driver = new Joystick(DRIVER_PORT);
    throttle = new Joystick(THROTTLE_PORT);
    manipulator = new Joystick(MANIPULATOR_PORT);

    shootHighButton =new JoystickButton(manipulator, SHOOT_HIGH_BUTTON);
    shootLowButton =new JoystickButton(manipulator, SHOOT_LOW_BUTTON);
    hopperForwardButton =new JoystickButton(manipulator, HOPPER_FORWARD_BUTTON);
    hopperReverseButton =new JoystickButton(manipulator, HOPPER_REVERSE_BUTTON);

    shootHighButton.whenHeld(m_shootHigh);
    shootLowButton.whenHeld(m_shootLow);
    hopperForwardButton.whenHeld(m_hopperForward);
    hopperReverseButton.whenHeld(m_hopperReverse);

  }

  public static double getDriverAxis(){
    return driver.getX();
  }

  public static double getDriverThrottle(){
    return throttle.getY();
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
