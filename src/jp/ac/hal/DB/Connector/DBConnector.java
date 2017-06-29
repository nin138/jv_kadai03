package jp.ac.hal.DB.Connector;

import java.sql.ResultSet;
import java.sql.SQLException;


abstract class DBConnector implements AutoCloseable {
  abstract protected void getConnection() throws SQLException;
  abstract protected void buildStatement(String sql, String[] args) throws SQLException;
  abstract protected void execUpdate(String sql, String[] args) throws SQLException;
  abstract protected void execUpdate(String sql) throws SQLException;
  abstract protected ResultSet execQuery(String sql, String[] args) throws SQLException;
  abstract protected ResultSet execQuery(String sql) throws SQLException;
}
