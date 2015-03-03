//
// npm install johnny-five
//

var five = require("johnny-five"),
    button, led;

five.Board({
  port: "/dev/cu.usbmodem1451"
}).on("ready", function() {

  button = new five.Button({
    pin: 4,
    isPullup: true
  });

  led = new five.Led(7);

  button.on("down", function(value) {
    console.log("down");
    led.on(10);
  });

  button.on("up", function() {
    console.log("up");
    led.off();
  });

});