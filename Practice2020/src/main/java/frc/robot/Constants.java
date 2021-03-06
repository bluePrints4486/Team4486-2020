/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static class MotorPorts{
        public static final int RIGHT = 0;
        public static final int LEFT = 1;
        public static final int SHOOTER = 2;
        public static final int HOPPER = 3;
        
    
        
    }
    public static class JoystickPorts{
        public static final int DRIVER_PORT = 0;
        public static final int THROTTLE_PORT = 1;
        public static final int MANIPULATOR_PORT = 2;
        public static final int SHOOT_HIGH_BUTTON = 2;
        public static final int SHOOT_LOW_BUTTON = 3;
        public static final int HOPPER_FORWARD_BUTTON = 1;
        public static final int HOPPER_REVERSE_BUTTON = 5;
    
        
    }
}
