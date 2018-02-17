/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1325.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    public static final Joystick joystick1 = new Joystick(0);//Gamepad F310
    public static final Joystick joystick2 = new Joystick(1);//Logitech Dual Action
    private static OI instance;
    private JoystickButton A = new JoystickButton(joystick1, 1);
    private JoystickButton B = new JoystickButton(joystick1, 2);
    private JoystickButton X = new JoystickButton(joystick1, 3);
    private JoystickButton Y = new JoystickButton(joystick1, 4);
    private JoystickButton LB = new JoystickButton(joystick1, 5);
    private JoystickButton RB = new JoystickButton(joystick1, 6);
    private JoystickButton Back = new JoystickButton(joystick1, 7);
    private JoystickButton Start = new JoystickButton(joystick1, 8);

    private JoystickButton X_2 = new JoystickButton(joystick2, 1);
    private JoystickButton A_2 = new JoystickButton(joystick2, 2);
    private JoystickButton B_2 = new JoystickButton(joystick2, 3);
    private JoystickButton Y_2 = new JoystickButton(joystick2, 4);
    private JoystickButton LB_2 = new JoystickButton(joystick2, 5);
    private JoystickButton RB_2 = new JoystickButton(joystick2, 6);
    private JoystickButton LT_2 = new JoystickButton(joystick2, 7);
    private JoystickButton RT_2 = new JoystickButton(joystick2, 8);
    private JoystickButton Back_2 = new JoystickButton(joystick2, 9);
    private JoystickButton Start_2 = new JoystickButton(joystick2, 10);

    public OI(){
//        B_2.toggleWhenActive(new OuttakeSequence(false, 0.0));
//        X_2.toggleWhenActive(new AgitatorToggle());
//        LT_2.whenActive(new OpenGear());
//        RT_2.whenActive(new CloseGear());
//        Back_2.whileActive(new ClimberControl());

    }
    public static OI getInstance() {
        return instance == null ? instance = new OI() : instance;
    }

}

