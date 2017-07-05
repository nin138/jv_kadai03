package jp.ac.hal.DB.Dao;

import jp.ac.hal.entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDao extends SuperDao implements AutoCloseable {
  static private final String URL = "jdbc:mysql://localhost:3306/jv";
  static private final String user = "root";
  static private final String password = "";
  public UserDao() throws SQLException {
    super(UserDao.URL, UserDao.user, UserDao.password);
  }
  public List<User> getAllUser() throws SQLException {
    ArrayList<User> users = new ArrayList<>();
    ResultSet resultSet = this.execQuery("select id, name, address from t_user");
    while (resultSet.next()) {
      users.add(new User(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("address")));
    }
    return users;
  }
  public User getUserById(int id) throws SQLException {
    User user = null;
    String[] args = { String.valueOf(id) };
    ResultSet resultSet = this.execQuery("select id, name, address from t_user where id=?", args);
    if(resultSet.next()) { user = new User(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("address")); }
    return user;
  }
}
