package jp.ac.hal.entity;


import java.util.List;

public class Order {
  public int id;
  public int user_id;
  public String date;
  public List<OrderDetail> details;
  public Order(int id, int user_id, String date) {
    this.id = id;
    this.user_id = user_id;
    this.date = date;
  }
}
