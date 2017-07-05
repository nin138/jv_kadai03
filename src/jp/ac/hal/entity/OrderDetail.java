package jp.ac.hal.entity;

public class OrderDetail {
  public int order_id;
  public int product_id;
  public int qty;
  public OrderDetail(int order_id, int product_id, int qty) {
    this.order_id = order_id;
    this.product_id = product_id;
    this.qty = qty;
  }
}
