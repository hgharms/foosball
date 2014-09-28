package nl.trio.foosball.dao.sql2o;

import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.List;

public class Dao {

  private static Sql2o sql2o;

  static {
    sql2o = new Sql2o("java:/comp/env/jdbc/TestappDS");
  }

  protected  static <T> List<T> select(final String strQuery, final Class<T> clazz, Parameter... parameters) {
    try (Connection con = sql2o.open()) {
      Query query = con.createQuery(strQuery);
      addParameters(query, parameters);
      return query.executeAndFetch(clazz);
    }
  }

  protected static <T> T find(final String strQuery, final Class<T> clazz, Parameter... parameters) {
    try (Connection con = sql2o.open()) {
      Query query = con.createQuery(strQuery);
      addParameters(query, parameters);
      return query.executeAndFetchFirst(clazz);
    } catch (Throwable e) {
      throw e;
    }
  }

  protected static <T> T find(final String strQuery, final Class<T> clazz, final List<ColumnMapping> columnMappings, Parameter... parameters) {
    try (Connection con = sql2o.open()) {
      Query query = con.createQuery(strQuery);
      addColumnMappings(query, columnMappings);
      addParameters(query, parameters);
      return query.executeAndFetchFirst(clazz);
    } catch (Throwable e) {
      throw e;
    }
  }

  private static void addColumnMappings(Query query, List<ColumnMapping> columnMappings) {
    for (ColumnMapping columnMapping : columnMappings) {
      query.addColumnMapping(columnMapping.getSqlName(), columnMapping.getModelName());
    }
  }

  private static void addParameters(Query query, Parameter... parameters) {
    for (Parameter parameter : parameters) {
      query.addParameter(parameter.getName(), parameter.getValue());
    }
  }
}
