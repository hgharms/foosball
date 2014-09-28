package nl.trio.foosball.socket;

import com.pi4j.io.serial.*;
import nl.trio.foosball.dao.sql2o.ColumnMapping;
import nl.trio.foosball.dao.sql2o.MyDao;
import nl.trio.foosball.dao.sql2o.Parameter;
import nl.trio.foosball.model.Game;
import org.slf4j.Logger;

import java.util.Arrays;
import java.util.List;

public class ArduinoListener {

  private Logger logger      = org.slf4j.LoggerFactory.getLogger(getClass());
  private static ArduinoListener instance;
  private static Thread listener = null;

  public static ArduinoListener getInstance(){
    if(instance == null){
      instance = new ArduinoListener();
    }
    return instance;
  }

  public boolean isStarted(){
    return listener != null;
  }

  public void startListener(){
    if(!isStarted()){
      listener = new Thread() {
        public void run() {
          if (!isDummy()) {
            logger.info("Listen to arduino");
            arduinoChat();
          } else {
            logger.info("Dummy");
            dummyChat();
          }
        }
      };
      listener.start();//two concurrent threads
    }
  }

  public boolean isDummy(){
//    System.out.println(System.getProperty("os.name"));
//    System.out.println(System.getProperty("os.arch"));
//    return false; //!System.getenv("PATH").contains("/usr/local/sbin");
//    return !System.getenv("PATH").contains("/usr/local/sbin");//tja
    return true;
  }

  public String getCurrentScore(){
    final Game game = MyDao.findActiveGame();
    if(game == null){
      return "No current game";
    } else {
      return game.getScore();
    }
  }

  private void dummyChat() {
    String [] s = {
        "Start...",
        "1 -0",
        "1 -1",
        "2 -1",
        "3 -1",
        "4 -1",
        "5 -1",
        "6 -1",
        "7 -1",
        "8 -1",
        "9 -1",
        "10 -1",
        "Ended."
    };
    for (String score : s) {
      Socket.sendScoreToClients(score);
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public void arduinoChat() {

    //ttyACM0

    // create an instance of the serial communications class
    try {
      final Serial serial = SerialFactory.createInstance();
      serial.open("/dev/ttyACM0", 9600);
      // create and register the serial data listener
      serial.addListener(new SerialDataListener() {
        @Override
        public void dataReceived(SerialDataEvent event) {
          Socket.sendScoreToClients(event.getData());
        }
      });
    } catch (SerialPortException e) {
      logger.error("dddd",e);
      e.printStackTrace();
    }

  }

  public void stopListener(){
    listener = null;
  }
}
