package jp.ac.hal.DB.Connector;

import java.sql.DriverManager;
import java.sql.SQLException;

class MySQLConnector extends DBConnector {
  private String url = "jdbc:mysql://localhost:3306/jv";
  private String user = "";
  private String password = "";

  MySQLConnector(String url, String user, String password) {
    this.url = url;
    this.user = user;
    this.password = password;
  }
  public void getConnection() throws SQLException {
    try {
      Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException e) { e.printStackTrace(); }
    connection = DriverManager.getConnection(url, user, password);
  }
  public void close() {
    try {
      if(resultSet != null) resultSet.close();
      if(preparedStatement != null) preparedStatement.close();
      if(connection != null) connection.close();
    } catch (Exception e) { e.printStackTrace(); }
  }
}

