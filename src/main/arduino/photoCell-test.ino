// set pin numbers:
int photoCell = A1;   // analog in
int ledPin    =  13;  // the number of the LED pin

void setup() {
  // initialize the LED pin as an output:
  pinMode(ledPin, OUTPUT);
  Serial.begin(9600);
}

void loop() {
  // read the value of the photocell
  // beamValue is between 0 and 1023
  int beamValue = analogRead(photoCell);
  Serial.print("Beam value was: ");
  Serial.println(beamValue);

  if (beamValue < 500) {
    // turn LED on:
    digitalWrite(ledPin, HIGH);
    // leave LED on for 1 sec.
    delay(1000);
  }  else {
    // turn LED off:
    digitalWrite(ledPin, LOW);
  }
}

