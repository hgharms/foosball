package nl.trio.foosball.dao.sql2o;

import nl.trio.foosball.model.Game;
import nl.trio.foosball.model.Player;

import java.util.List;

public class MyDao extends Dao{

  public static Game findActiveGame(){
    final String query = "SELECT "+ Game.SELECT_COLUMNS + " FROM Game WHERE Active = :active";
    return find(query, Game.class, new Parameter("active", true));
//    final String query = "SELECT * FROM Game WHERE Active = :active"; //select *  al de setters moeten aanwezig zijn.
//    final List<ColumnMapping> columnMappings = Arrays.asList(new ColumnMapping("team_1", "team_1_id"), new ColumnMapping("team_2", "team_2_id"));
//    final Game game = MyDao.find(query, Game.class, columnMappings, new Parameter("active", true));
  }

  public static List<Player> selectPlayers() {
    return select("SELECT * From Player", Player.class);
  }

}