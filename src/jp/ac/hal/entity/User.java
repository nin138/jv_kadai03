package jp.ac.hal.entity;

public class User {
  User(int id, String name, String address) {
    this.id = id;
    this.name = name;
    this.address = address;
  }
  public int id;
  public String name;
  public String address;
}
