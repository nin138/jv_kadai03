package jp.ac.hal.DB.Connector;


public class ConnectorFactory {
  public static DBConnector getDBConnector(String url, String name, String password) {
    return new MySQLConnector(url, name, password);
  }
}
