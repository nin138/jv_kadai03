package jp.ac.hal.DB.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import jp.ac.hal.DB.Connector.ConnectorFactory;
import jp.ac.hal.DB.Connector.DBConnector;

abstract class SuperDao implements AutoCloseable {
  private DBConnector connector;
  SuperDao(String url, String user, String password) throws SQLException {
    connector = ConnectorFactory.getDBConnector(url, user, password);
    connector.getConnection();
  }
  private void buildStatement(String sql, String[] args) throws SQLException {
    connector.preparedStatement = connector.connection.prepareStatement(sql);
    for(int i = 0; i < args.length; i++) {
      connector.preparedStatement.setString(i+1, args[i]);
    }
  }
  protected void execUpdate(String sql, String[] args) throws SQLException {
    this.buildStatement(sql, args);
    connector.preparedStatement.execute();
  }
  protected void execUpdate(String sql) throws SQLException {
    String[] args = {};
    this.execQuery(sql, args);
  }
  protected ResultSet execQuery(String sql, String[] args) throws SQLException {
    this.buildStatement(sql, args);
    connector.resultSet = connector.preparedStatement.executeQuery();
    return connector.resultSet;
  }
  protected ResultSet execQuery(String sql) throws SQLException {
    String[] args = {};
    return this.execQuery(sql, args);
  }
  @Override
  public void close() throws Exception {
    connector.close();
  }
}
