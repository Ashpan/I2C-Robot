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
        byte[] bits = new byte[1];
        //000 = Off | 001 = Disabled | 010 = Have Gear | 011 = Want Gear | 100 = Climb | 111 = No Gear
        if(DriverStation.getInstance().isDisabled()) {
            bits[0] = 49;
            //MATCH MODE^^
            //setAll(0, 0, 0);
            //DEV MODE^^
        } else if(!DriverStation.getInstance().isDisabled()) {
            if(OI.joystick1.getRawButton(6))
                System.out.println("6");
//                bits[0] = 21;//Want Gear
            else if((DriverStation.getInstance().getMatchTime() != -1.0))
                System.out.println("time");
//                bits[0] = 56;//Climb
            else
                bits[0] = 34;
            //No Gear
        } else
            System.out.println("0");
//            bits[0] = 00;
        //Off
        byte[] bits2 = new byte[1];
        bits2[0] = 0;
        i2c.transaction(bits, 1, bits2,0);
    }

}