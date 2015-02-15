
int score1_plus = 6;
int score1_min  = 5;
int reset       = 4;
int score2_plus = 3;
int score2_min  = 2;

void setup() {

  // configure input pins
  pinMode(score1_plus, INPUT);
  pinMode(score1_min,  INPUT);
  pinMode(score2_plus, INPUT);
  pinMode(score2_min,  INPUT);
  pinMode(reset,       INPUT);

  // switch on internal pull-up resistors
  digitalWrite(score1_plus, HIGH);
  digitalWrite(score1_min,  HIGH);
  digitalWrite(score2_plus, HIGH);
  digitalWrite(score2_min,  HIGH);
  digitalWrite(reset,  HIGH);

  Serial.begin(9600);
  Serial.println("Button test");
}

void loop() {
  if (buttonPressed(score1_plus)) Serial.println("Scoreboard 1 - Plus");
  if (buttonPressed(score1_min))  Serial.println("Scoreboard 1 - Min");
  if (buttonPressed(score2_plus)) Serial.println("Scoreboard 2 - Plus");
  if (buttonPressed(score2_min))  Serial.println("Scoreboard 2 - Min");
  if (buttonPressed(reset))       Serial.println("Reset");
  
  delay(500);
}

boolean buttonPressed(int button) {
  return digitalRead(button) == LOW;
}
