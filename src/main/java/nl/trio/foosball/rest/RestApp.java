package nl.trio.foosball.rest;


import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("rest")
public class RestApp extends ResourceConfig{
 public RestApp() {
         packages("nl.trio.foosball.rest");
 }
}
