package jp.ac.hal.entity;

public class User {
  public int id;
  public String name;
  public String address;
  public User(int id, String name, String address) {
    this.id = id;
    this.name = name;
    this.address = address;
  }
}