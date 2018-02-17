This program uses the I2C interface to connect the roboRIO to an Arduino and communicates to the Arduino.  
The relevant Arduino code is in the src code files under **ArduinoLEDS.java** and the Arduino file is under the **ArduinoCode** folder.
The connections are as follows

roboRIO (I2C Interface) | Arduino
--------|---------
GND | GND
3.3V | Vin
SCL | A5
SDA | A4

LED Strip | Arduino | VRM
----------|---------|-----
+5V | N/A | +ve 5V2A
DI | Digital 10 | N/A
GND | N/A | -ve 5V2A
