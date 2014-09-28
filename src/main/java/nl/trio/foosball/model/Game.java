package nl.trio.foosball.model;

import java.io.Serializable;

public class Game implements Serializable{

  public static final String SELECT_COLUMNS = "team_1 AS team_1_id, team_2 AS team_2_id, score_team_1, score_team_2, active";

  private long id;
  private long team_1_id,team_2_id;//TODO temp

  private Team team_1;
  private Team team_2;

  private int score_team_1;
  private int score_team_2;

  private boolean active;

  public String getScore(){
    return score_team_1 + " : " + score_team_2;
  }

  public long getId() {
    return id;
  }

  public long getTeam_1_id() {
    return team_1_id;
  }

  public void setTeam_1_id(long team_1_id) {
    this.team_1_id = team_1_id;
  }

  public long getTeam_2_id() {
    return team_2_id;
  }

  public void setTeam_2_id(long team_2_id) {
    this.team_2_id = team_2_id;
  }

  public Team getTeam_1() {
    return team_1;
  }

  public void setTeam_1(Team team_1) {
    this.team_1 = team_1;
  }

  public Team getTeam_2() {
    return team_2;
  }

  public void setTeam_2(Team team_2) {
    this.team_2 = team_2;
  }

  public int getScore_team_1() {
    return score_team_1;
  }

  public void setScore_team_1(int score_team_1) {
    this.score_team_1 = score_team_1;
  }

  public int getScore_team_2() {
    return score_team_2;
  }

  public void setScore_team_2(int score_team_2) {
    this.score_team_2 = score_team_2;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }
}
