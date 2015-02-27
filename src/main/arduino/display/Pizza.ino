#include <Display_RF.h>

#define PIN_SCE   2//7  // LCD CS  .... Pin 3
#define PIN_RESET 6  // LCD RST .... Pin 1
#define PIN_DC    5  // LCD Dat/Com. Pin 5
#define PIN_SDIN  4  // LCD SPIDat . Pin 6
#define PIN_SCLK  3  // LCD SPIClk . Pin 4
                     // LCD Gnd .... Pin 2
                     // LCD Vcc .... Pin 8
                     // LCD Vlcd ... Pin 7

Display_RF d(PIN_SCE,PIN_SCLK, PIN_SDIN, PIN_DC, PIN_RESET);
int buttonState = 0;

const int buttonPin = 9;

void setup(void){
  d.LcdInitialise();
  d.LcdClear();
    
  pinMode(buttonPin, INPUT);     
  Serial.begin(9600);

}

int scoreA, scoreB = 0;
String score;

void loop(void){
  
  buttonState = digitalRead(buttonPin);
  boolean scored= false;
  if (buttonState == HIGH) {     
    scored=true;
    if(random(0,2) ==0){
    scoreA+=1;
    } else {
      scoreB+=1;
    }
    score = String(scoreA) + " "+ String(scoreB);
    delay(500);//beter is een capacitor
  } 
  d.gotoXY(24,1);
  char charBuf[50];
  score.toCharArray(charBuf, 50); 
  d.LcdString (charBuf);
  if(scored){
    Serial.println(score);
    scored= false;
  }
}