/*************************************************** 
 test with adafruit 16 channel servo/led driver
 ****************************************************/

#include <Wire.h>
#include <Adafruit_PWMServoDriver.h>

Adafruit_PWMServoDriver scoreboard1 = Adafruit_PWMServoDriver(0x40);
Adafruit_PWMServoDriver scoreboard2 = Adafruit_PWMServoDriver(0x41);

const int maxPwmFrequency = 1600;
const int loopDelayMs = 100;
const int blinkDelayMs = 110;

void setup() {
  Serial.begin(9600);
  Serial.println("Scoreboard demo");

/* copied from Adafruit PWM demo */

  // if you want to really speed stuff up, you can go into 'fast 400khz I2C' mode
  // some i2c devices dont like this so much so if you're sharing the bus, watch
  // out for this!

  scoreboard1.begin();
  scoreboard1.setPWMFreq(maxPwmFrequency);  
    
  scoreboard2.begin();
  scoreboard2.setPWMFreq(maxPwmFrequency);  

  // save I2C bitrate
  uint8_t twbrbackup = TWBR;
  // must be changed after calling Wire.begin() (inside scoreboardx.begin())
  //TWBR = 12; // upgrade to 400KHz!
    
    
}

void loop() {
    ledOn1(getRandom());
    
    delay(loopDelayMs);

    ledOff1(getRandom());
    ledOn2(getRandom());
    
    delay(loopDelayMs);
    
    ledOff2(getRandom());
}

int getRandom() {
  return random(0, 5);
}

void ledOff1(int port) {
  scoreboard1.setPWM(port, 0, 4096);
}

void ledOn1(int port) {
  scoreboard1.setPWM(port, 4096, 0);
}

void ledOff2(int port) {
  scoreboard2.setPWM(port, 0, 4096);
}

void ledOn2(int port) {
  scoreboard2.setPWM(port, 4096, 0);
}


void blinkAll() {
  for(int count = 0; count < 5; count++) {
    ledOn1(0);
    ledOn1(1);
    ledOn1(2);
    ledOn1(3);
    ledOn1(4);
    ledOn2(0);
    ledOn2(1);
    ledOn2(2);
    ledOn2(3);
    ledOn2(4);
    
    delay(blinkDelayMs);

    ledOff1(0);
    ledOff1(1);
    ledOff1(2);
    ledOff1(3);
    ledOff1(4);
    ledOff2(0);
    ledOff2(1);
    ledOff2(2);
    ledOff2(3);
    ledOff2(4);
    
    delay(blinkDelayMs);
  }
}

