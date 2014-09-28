package nl.trio.foosball.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//@ServerEndpoint("/scoreListener")
public class ScoreListening implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent servletContextEvent) {

    System.out.println("Listener initialized");

//    TODO disabled in web.xml
  }

  @Override
  public void contextDestroyed(ServletContextEvent servletContextEvent) {

  }
}
