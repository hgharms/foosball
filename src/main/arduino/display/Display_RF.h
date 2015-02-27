#include "Arduino.h"

#ifndef Display_RF_h
#define Display_RF_h

class Display_RF
{
  public:
    Display_RF(int pin_sce, int pin_sclk, int pin_sdin, int pin_dc, int pin_reset );

//    void dot();
//    void dash();

    void LcdCharacter(char character);
    void LcdClear(void);
    void LcdInitialise(void);
    void LcdString(char *characters);
    void LcdWrite(byte dc, byte data);
    void gotoXY(int x, int y);
    void drawLine(void);


  private:
        int _pin_sce;
        int _pin_sclk;
        int _pin_sdin;
        int _pin_dc;
        int _pin_reset;
};


#endif

