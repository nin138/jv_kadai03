//package jp.ac.hal.DB;
//
//import jp.ac.hal.DB.Connector.DAO;
//import jp.ac.hal.entity.User;
//
//import java.util.List;
//
///**
// * Created by ninian on 2017/06/29.
// */
//public class UserDAO extends DAO {
//  UserDAO() {
//    super("jdbc:mysql://localhost:3306/jv", "root", "");
//  }
//  List<User> getAllUser() {
//    this.resultSet = this.execQuery("select id, name, address from t_user");
//  }
//
//}
