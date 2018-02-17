package org.usfirst.frc.team1325.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.I2C;

public class ArduinoLEDS {
    private static ArduinoLEDS instance;
    public I2C i2c = new I2C(I2C.Port.kOnboard,4); //I2C to control communicate with Arduino

    public static ArduinoLEDS getInstance() {
        return instance == null ? instance = new ArduinoLEDS() : instance;
    }

    public void run() {
        // 0 = Off | 1 = Disabled | 2 = Have Cube (needs sensor) | 3 = Want Cube | 4 = Climb | 5 = No Cube
        byte[] bits = new byte[1];
        if(DriverStation.getInstance().isDisabled()) {
            bits[0] = 1;
        }else if(!DriverStation.getInstance().isDisabled()) {
            if(OI.joystick1.getRawButton(6))
                bits[0] = 3;
            else if((DriverStation.getInstance().getMatchTime() != -1.0))
                bits[0] = 4;
            else
                bits[0] = 5;
        } else
            bits[0] = 0;
        //Off
        byte[] bits2 = new byte[1];
        bits2[0] = 0;
        i2c.transaction(bits, 1, bits2,0);
    }

}