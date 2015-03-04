// Arduino RFID scanner
// 
// Hardware needed:
// - MFRC522 RFID reader (connected with SPI)
// - Piezoelectric speaker (between ground and pin 9)
//
// Libraries to import:
// - SPI (from the standard Arduino libraries)
// - Arduino RFID Library for MFRC522 (from https://github.com/miguelbalboa/rfid)

#include <SPI.h>
#include <MFRC522.h>

#define RST_PIN		9 
#define SS_PIN		10

MFRC522 mfrc522(SS_PIN, RST_PIN);

String detectedUid = "";

int speakerPin = 9;

int length = 4; // the number of notes
char notes[] = "eeec"; // a space represents a rest
int beats[] = { 1, 1, 1, 4 };
int tempo = 150;

void playTone(int tone, int duration) {
  for (long i = 0; i < duration * 1000L; i += tone * 2) {
    digitalWrite(speakerPin, HIGH);
    delayMicroseconds(tone);
    digitalWrite(speakerPin, LOW);
    delayMicroseconds(tone);
  }
}

void playNote(char note, int duration) {
  char names[] = { 'c', 'd', 'e', 'f', 'g', 'a', 'b', 'C' };
  int tones[] = { 1915, 1700, 1519, 1432, 1275, 1136, 1014, 956 };
  
  // play the tone corresponding to the note name
  for (int i = 0; i < 8; i++) {
    if (names[i] == note) {
      playTone(tones[i], duration);
    }
  }
}

void setup() {
        pinMode(speakerPin, OUTPUT);
	Serial.begin(9600);		// Initialize serial communications with the PC
	while (!Serial);		// Do nothing if no serial port is opened (added for Arduinos based on ATMEGA32U4)
	SPI.begin();			// Init SPI bus
	mfrc522.PCD_Init();		// Init MFRC522
	ShowReaderDetails();	// Show details of PCD - MFRC522 Card Reader details
	Serial.println(F("Scan PICC to see UID..."));
}

void loop() {
	// Look for new cards
	if ( ! mfrc522.PICC_IsNewCardPresent()) {
		return;
	}

	// Select one of the cards
	if ( ! mfrc522.PICC_ReadCardSerial()) {
		return;
	}

        String newUid = "";
        String label = "ID: ";
        for (int i = 0; i < mfrc522.uid.size; i++) {
          newUid += mfrc522.uid.uidByte[i];
          if (i != mfrc522.uid.size - 1) {
            newUid += ".";
          }
        }
        
        if (!newUid.equals(detectedUid)) {
          Serial.println(newUid);
          detectedUid = newUid;
          for (int i = 0; i < length; i++) {
            if (notes[i] == ' ') {
              delay(beats[i] * tempo); // rest
            } else {
              playNote(notes[i], beats[i] * tempo);
            }
            
            // pause between notes
            delay(tempo / 2); 
          }
        }
}

void ShowReaderDetails() {
	// Get the MFRC522 software version
	byte v = mfrc522.PCD_ReadRegister(mfrc522.VersionReg);
	Serial.print(F("MFRC522 Software Version: 0x"));
	Serial.print(v, HEX);
	if (v == 0x91)
		Serial.print(F(" = v1.0"));
	else if (v == 0x92)
		Serial.print(F(" = v2.0"));
	else
		Serial.print(F(" (unknown)"));
	Serial.println("");
	// When 0x00 or 0xFF is returned, communication probably failed
	if ((v == 0x00) || (v == 0xFF)) {
		Serial.println(F("WARNING: Communication failure, is the MFRC522 properly connected?"));
	}
}
