package nl.trio.foosball.model;

import java.io.Serializable;

public class Team implements Serializable {

  private long id;
  private Player player_1;
  private Player player_2;

  //TODO temp..
  private long player_1_id, player_2_id;

  public long getPlayer_1_id() {
    return player_1_id;
  }

  public void setPlayer_1_id(long player_1_id) {
    this.player_1_id = player_1_id;
  }

  public long getPlayer_2_id() {
    return player_2_id;
  }

  public void setPlayer_2_id(long player_2_id) {
    this.player_2_id = player_2_id;
  }

  public long getId() {
    return id;
  }

  public Player getPlayer_1() {
    return player_1;
  }

  public void setPlayer_1(Player player_1) {
    this.player_1 = player_1;
  }

  public Player getPlayer_2() {
    return player_2;
  }

  public void setPlayer_2(Player player_2) {
    this.player_2 = player_2;
  }
}
