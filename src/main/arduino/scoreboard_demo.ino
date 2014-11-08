/*************************************************** 
 test with adafruit 16 channel servo/led driver
 ****************************************************/

#include <Wire.h>
#include <Adafruit_PWMServoDriver.h>

Adafruit_PWMServoDriver scoreboard1 = Adafruit_PWMServoDriver(0x40);
Adafruit_PWMServoDriver scoreboard2 = Adafruit_PWMServoDriver(0x41);

const int maxPwmFrequency = 1600;
const int scoreDelayMs = 2000;
const int blinkDelayMs = 110;

const int buttonPin = 2;
int buttonState = 0;

int score = 0;

void setup() {
  pinMode(buttonPin, INPUT);
  
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
  TWBR = 12; // upgrade to 400KHz!
  
  ledsOff(8);
    
}

void loop() {
  //Serial.println("  - demo scoreboard 1 (address 0x40)");   
  
  buttonState = digitalRead(buttonPin);
  if (buttonState == HIGH) {     
    score = score + 1;
    //Serial.println("Score: " + score);
    scoreBoard(score);
    
    if (score == 9) {
      score = 0;
      ledsOff(8);
    } 
  } 
  
}

void scoreBoard(int nr) {
  blinkAll();
  ledsOn(nr);
}

void blinkAll() {
  for(int count = 0; count < 5; count++) {
    ledsOn(8);   
    delay(blinkDelayMs);
    ledsOff(8); 
    delay(blinkDelayMs);
  }
}

void ledsOn(int nr) {
   for (int led = 0; led < nr; led++) {
    ledOn(led);
  }  
}

void ledOn(int port) {
  //Serial.println("  - led ON");
  scoreboard1.setPWM(port, 4096, 0);
}

void ledsOff(int nr) {
   for (int led = 0; led < nr; led++) {
    ledOff(led);
  }  
}

void ledOff(int port) {
  //Serial.println("  - led OFF");
  scoreboard1.setPWM(port, 0, 4096);
}

void blinkArduinoLed() {
  int arduinoLed = 13; // visual debugger ;-)
  digitalWrite(arduinoLed, HIGH);
  delay(300);
  digitalWrite(arduinoLed, LOW);
}


