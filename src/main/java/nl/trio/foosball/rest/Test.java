package nl.trio.foosball.rest;

import com.google.gson.Gson;
import nl.trio.foosball.dao.jpa.Dba;
import nl.trio.foosball.dao.sql2o.MyDao;
import nl.trio.foosball.model.Gender;
import nl.trio.foosball.model.Player;

//import javax.persistence.EntityManager;
//import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Path("json")
public class Test {

  @GET
  @Produces({"application/json"})
  public String doGetAsXmlOrJson() {
//    final Dba dba = new Dba();
//    final EntityManager em = dba.getActiveEm();
//   Player pietje = new Player("Pietje", (int) (Math.random() * 100), Gender.FEMALE.toString());
//   Player klaasje = new Player("Klaasje", (int) (Math.random() * 100), Gender.MALE.toString());


//   em.persist(pietje);
//   em.persist(klaasje);

//    Query query  = em.createQuery("From Player p");
//    final List resultList = query.getResultList();

//    dba.closeEm();

    final List<Player> players = MyDao.selectPlayers();
    return new Gson().toJson(players);
  }
}
