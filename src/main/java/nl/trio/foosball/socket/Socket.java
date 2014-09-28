package nl.trio.foosball.socket;

import org.slf4j.Logger;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@ServerEndpoint(value = "/socket")
public class Socket {
  protected static Logger logger = org.slf4j.LoggerFactory.getLogger(Socket.class);

  static Queue<Session> queue = new ConcurrentLinkedQueue<>();

  @OnOpen
  public void onOpen(Session session) {
    logger.info(session.getId() + "OPen");

    queue.add(session);

    ArduinoListener instance = ArduinoListener.getInstance();
    if(!instance.isStarted()){
      instance.startListener();
    } else {
      String currentScore = instance.getCurrentScore();
      sendMessageToClient(session, "Current score: " + currentScore);
    }
  }

  @OnMessage
  public void onMessage(Session session, String message) throws IOException {
    sendMessageToClient(session, "echo: " + message);
  }

  @OnClose
  public void onClose(Session session) {
    logger.info(session.getId() + " On close");
    queue.remove(session);

    if (queue.isEmpty()) {
      ArduinoListener.getInstance().stopListener();
    }
  }

  public static void sendScoreToClients(String score){
    for (Session session : queue) {
      sendMessageToClient(session, score);
    }
  }

  private static void sendMessageToClient(Session session, String message) {
    try {
      session.getBasicRemote().sendText(message);
    } catch (IOException e) {
      logger.error("Message couldn't be sent to client", e);
    }
  }

  @OnError
  public void error(Session session, Throwable t) {
    logger.error("Arghhh", t);
  }
}
