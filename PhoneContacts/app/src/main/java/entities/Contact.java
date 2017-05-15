package entities;

import java.io.Serializable;

/**
 * Created by edima on 2017-05-14.
 */

public class Contact implements Serializable {

  private int id;
  private String name;
  private String phone;

  public Contact(int id, String name, String phone) {
    this.id = id;
    this.name = name;
    this.phone = phone;
  }

  public Contact() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }
}
