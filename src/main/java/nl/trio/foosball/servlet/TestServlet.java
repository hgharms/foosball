package nl.trio.foosball.servlet;

import com.pi4j.io.gpio.*;
import nl.trio.foosball.socket.ArduinoListener;
import nl.trio.foosball.socket.Socket;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.util.Map;

public class TestServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    Map<String, String> getenv = System.getenv();
    StringBuilder builder = new StringBuilder();
    for (Map.Entry<String, String> entry : getenv.entrySet()) {
      builder.append(entry.getKey() + " : " +  entry.getValue() + "<br/>");
    }


    String test = "test";
/*
    GpioController gpio = null;
    try {
      gpio = GpioFactory.getInstance();

      // provision gpio pin #01 as an output pin and turn on
      final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00);

      if(pin.getState().isHigh()){
        pin.setState(PinState.LOW);
      } else {
        pin.setState(PinState.HIGH);
      }

      test = pin.getState().getName();



      Thread.sleep(500L);

      gpio.shutdown();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      if(gpio != null){
        gpio.shutdown();
      }
    }
*/

    out.println("<html>");
    out.println("<body>");
    out.println("<h1>Blaat " + test +  builder.toString() + "</h1>");
    out.println("</body>");
    out.println("</html>");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    super.doPost(req, resp);
  }
}
