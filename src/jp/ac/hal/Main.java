package jp.ac.hal;

import jp.ac.hal.DB.Dao.OrderDao;
import jp.ac.hal.DB.Dao.UserDao;
import jp.ac.hal.entity.Order;
import jp.ac.hal.entity.OrderDetail;
import jp.ac.hal.entity.User;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    try(UserDao userDao = new UserDao(); OrderDao orderDao = new OrderDao()) {

      List<User> users = userDao.getAllUser();
      for (User u : users) {
        System.out.println("id:" + u.id + ",name:" +u.name + ",address:" + u.address);
      }
      System.out.println();

      List<Order> orders = orderDao.getAllOrderWithDetail();
      for(Order o : orders) {
        System.out.println("id:" + o.id + ",user_id:" + o.user_id + ",date:" + o.date);
        for(OrderDetail od : o.details) {
          System.out.println("order_id:" + od.order_id + ",product_id:" + od.product_id + ",qty:" + od.qty);
        }
        System.out.println();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}