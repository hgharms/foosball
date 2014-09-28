package nl.trio.foosball.dao.sql2o;

public class Parameter {

  private String name;
  private Object value;

  public Parameter(String name, Object value) {
    this.name = name;
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public Object getValue() {
    return value;
  }
}
