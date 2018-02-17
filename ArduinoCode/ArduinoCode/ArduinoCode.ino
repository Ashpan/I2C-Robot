//------LIBRARIES--------
#include <Wire.h>
#include <FastLED.h>
#include <Adafruit_NeoPixel.h>
//-----------------------

//------LED SETUP--------
#define DATA_PIN    10
#define NUM_LEDS    13
#define BRIGHTNESS  4095
#define LED_TYPE    WS2812B
#define COLOR_ORDER GRB
CRGB leds[NUM_LEDS];
#define UPDATES_PER_SECOND 100
CRGBPalette16 currentPalette;
TBlendType    currentBlending;
extern CRGBPalette16 myRedWhiteBluePalette;
extern const TProgmemPalette16 myRedWhiteBluePalette_p PROGMEM;
boolean firstGreenTrigger = false;
boolean firstRedTrigger = false;
//-----------------------

void setup() {
Wire.begin(4); //I2C Address set on the master device (roboRIO)
Wire.onReceive(Receive);
Serial.begin(9600);
}

void loop() {
}
void Receive(){
  byte c = Wire.read(); //Reads value received from I2C and stores it in "c"

  switch(c){
    case 0: //Off
      off();
      break;
    case 1; //Disabled
      disabled();
      break;
    case 2: //Have Cube
      haveCube();
      break;
    case 3: //Want Cube
      wantCube();
      break;
    case 4; //Climb
      climb();
      break;
    case 5: //No Cube
      noCube();
      break;
  }
}

void off(){
  FastLED.clear();
  FastLED.show();
}

void disabled(){
  FastLED.setBrightness(BRIGHTNESS);
  FastLED.clear();
  static uint8_t hue = 0;
  FastLED.showColor(CHSV(hue++, 255, 255));
  FastLED.show();
}

void haveCube(){
  FastLED.clear();
  FastLED.setBrightness(BRIGHTNESS);
  fill_solid(leds, NUM_LEDS, 0x00FF00);
  FastLED.show();
}

void wantCube(){
  FastLED.clear();
  FastLED.setBrightness(BRIGHTNESS);
  fill_solid(leds, NUM_LEDS, 0x0000FF);
  FastLED.show();
}

void noCube(){
    FastLED.clear();
  FastLED.setBrightness(BRIGHTNESS);
  fill_solid(leds, NUM_LEDS, 0xFF0000);
  FastLED.show();
}


void climb(uint8_t wait) {
  wait = 30;
  uint16_t i, j;

  for(j=0; j<256; j++) {
    for(i=0; i<strip.numPixels(); i++) {
      strip.setPixelColor(i, Wheel((i*1+j) & 255));
    }
    strip.show();
    delay(wait);
  }
}


// Input a value 0 to 255 to get a color value.
// The colours are a transition r - g - b - back to r.
uint32_t Wheel(byte WheelPos) {
  if(WheelPos < 85) {
    return strip.Color(WheelPos * 3, 255 - WheelPos * 3, 0);
  } 
  else if(WheelPos < 170) {
    WheelPos -= 85;
    return strip.Color(255 - WheelPos * 3, 0, WheelPos * 3);
  } 
  else {
    WheelPos -= 170;
    return strip.Color(0, WheelPos * 3, 255 - WheelPos * 3);
  }
}

