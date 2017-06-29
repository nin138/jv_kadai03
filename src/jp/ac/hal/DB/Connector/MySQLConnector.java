package jp.ac.hal.DB.Connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


class MySQLConnector extends DBConnector {
  private String url = "jdbc:mysql://localhost:3306/jv";
  private String user = "root";
  private String password = "";

  private Connection connection = null;
  private PreparedStatement preparedStatement = null;
  private ResultSet resultSet = null;

  MySQLConnector(String url, String user, String password) {
    this.url = url;
    this.user = user;
    this.password = password;
  }
  protected void getConnection() throws SQLException {
    try {
      Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) { e.printStackTrace(); }
    Connection connection = DriverManager.getConnection(url, user, password);
  }
  protected void buildStatement(String sql, String[] args) throws SQLException {
    preparedStatement = connection.prepareStatement(sql);
    for(int i = 0; i < args.length; i++) {
      preparedStatement.setString(i+1, args[i]);
    }
  }
  protected void execUpdate(String sql, String[] args) throws SQLException {
    this.getConnection();
    this.buildStatement(sql, args);
    preparedStatement.execute();
  }
  protected void execUpdate(String sql) throws SQLException {
    String[] args = {};
    this.execQuery(sql, args);
  }
  protected ResultSet execQuery(String sql, String[] args) throws SQLException {
    this.getConnection();
    this.buildStatement(sql, args);
    resultSet = preparedStatement.executeQuery();
    return resultSet;
  }
  protected ResultSet execQuery(String sql) throws SQLException {
    String[] args = {};
    return this.execQuery(sql, args);
  }
  public void close() {
    try {
      if(resultSet != null) resultSet.close();
      if(preparedStatement != null) preparedStatement.close();
      if(connection != null) connection.close();
    } catch (Exception e) { e.printStackTrace(); }
  }
}

