package org.usfirst.frc.team1325.robot;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.*;
import edu.wpi.first.wpilibj.smartdashboard.*;

@SuppressWarnings("unused")
public class Robot extends IterativeRobot {
	private OI oi = OI.getInstance();
	private RobotMap robotMap = RobotMap.getInstance();
	private ArduinoLEDS leds = ArduinoLEDS.getInstance();//Thx 1241
	private Command autonomousCommand;

	@Override
	public void robotInit() {
	}
	public void robotPeriodic() {
		this.leds.run();
	}

	@Override
	public void disabledInit() {
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}
}
