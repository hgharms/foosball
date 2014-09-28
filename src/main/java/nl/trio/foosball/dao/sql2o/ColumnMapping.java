package nl.trio.foosball.dao.sql2o;

public class ColumnMapping {

  private final String sqlName;
  private final String modelName;

  public ColumnMapping(String sqlName, String modelName) {
    this.sqlName = sqlName;
    this.modelName = modelName;
  }

  public String getSqlName() {
    return sqlName;
  }

  public String getModelName() {
    return modelName;
  }
}
