
const int score1_plus = 6;
const int score1_min  = 5;
const int reset       = 4;
const int score2_plus = 3;
const int score2_min  = 2;

void setup() {

  // configure input pins
  pinMode(score1_plus, INPUT);
  pinMode(score1_min,  INPUT);
  pinMode(score2_plus, INPUT_PULLUP);
  pinMode(score2_min,  INPUT_PULLUP);
  pinMode(reset,       INPUT_PULLUP);

  // switch on internal pull-up resistors for the 
  // inputs that are configured as INPUT iso INPUT_PULLUP
  digitalWrite(score1_plus, HIGH);
  digitalWrite(score1_min,  HIGH);

  Serial.begin(9600);
  Serial.println("Button test");
}

void loop() {
  if (buttonPressed(score1_plus)) Serial.println("Scoreboard 1 - Plus");
  if (buttonPressed(score1_min))  Serial.println("Scoreboard 1 - Min");
  if (buttonPressed(score2_plus)) Serial.println("Scoreboard 2 - Plus");
  if (buttonPressed(score2_min))  Serial.println("Scoreboard 2 - Min");
  if (buttonPressed(reset))       Serial.println("Reset");
  
  delay(100);
}

boolean buttonPressed(int button) {
  return digitalRead(button) == LOW;
}