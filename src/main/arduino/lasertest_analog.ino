// set pin numbers:
 int detectorPin = A1;    // analog in
 int ledPin =  13;      // the number of the LED pin

void setup() {
  // initialize the LED pin as an output:
  pinMode(ledPin, OUTPUT);   
  Serial.begin(9600);  
}

void loop(){
  // read the value of the photocell

  
//  if (beamvalue > 950) {     
//    // turn LED on:    
//    digitalWrite(ledPin, HIGH);  
//  }  else {
//    // turn LED off:
//    digitalWrite(ledPin, LOW); 
//  }

  int beamvalue = analogRead(detectorPin);
  Serial.print("Beam value was: ");
  Serial.println(beamvalue);
  
  if (beamvalue < 500) {     
    // turn LED on:    
    digitalWrite(ledPin, HIGH); 
    delay(1000); 
  }  else {
    // turn LED off:
    digitalWrite(ledPin, LOW); 
  }
}

