package jp.ac.hal.DB.Dao;

import jp.ac.hal.entity.Order;
import jp.ac.hal.entity.OrderDetail;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao extends SuperDao {
  static private final String URL = "jdbc:mysql://localhost:3306/jv";
  static private final String user = "root";
  static private final String password = "";
  public OrderDao() throws SQLException {
    super(OrderDao.URL, OrderDao.user, OrderDao.password);
  }
  public List<Order> getAllOrder() throws SQLException {
    ArrayList<Order> orders = new ArrayList<>();
    ResultSet resultSet = this.execQuery("select id, user_id, order_datetime from t_order");
    while (resultSet.next()) {
      orders.add(new Order(resultSet.getInt("id"), resultSet.getInt("user_id"), resultSet.getString("order_datetime")));
    }
    return orders;
  }
  public List<Order> getAllOrderWithDetail() throws SQLException {
    ArrayList<Order> orders = new ArrayList<>();
    ResultSet resultSet = this.execQuery("SELECT id,user_id,order_datetime,product_id,qty FROM t_order JOIN t_order_detail ON t_order.id = t_order_detail.order_id ORDER BY id ASC;");
    int id = -1;
    while (resultSet.next()) {
      if(id == resultSet.getInt("id")) {
        orders.get(orders.size()-1).details.add(new OrderDetail(resultSet.getInt("id"), resultSet.getInt("product_id"), resultSet.getInt("qty")));
      }
      else {
        Order o = new Order(resultSet.getInt("id"), resultSet.getInt("user_id"), resultSet.getString("order_datetime"));
        id = o.id;
        o.details = new ArrayList<>();
        o.details.add(new OrderDetail(resultSet.getInt("id"), resultSet.getInt("product_id"), resultSet.getInt("qty")));
        orders.add(o);
      }
    }
    return orders;
  }
}
