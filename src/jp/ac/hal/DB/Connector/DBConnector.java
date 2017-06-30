package jp.ac.hal.DB.Connector;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public abstract class DBConnector implements AutoCloseable {
  public Connection connection = null;
  public PreparedStatement preparedStatement = null;
  public ResultSet resultSet = null;
  abstract public void getConnection() throws SQLException;
}
