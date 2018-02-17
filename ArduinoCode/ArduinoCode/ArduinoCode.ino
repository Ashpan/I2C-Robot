#include <Wire.h>
void setup() {
Wire.begin(4);
Wire.onReceive(Receive);
Serial.begin(9600);

}

void loop() {


}
void Receive()
{
  
  byte c = Wire.read();
  Serial.println("running loops");
  Serial.println(c);
    
}
