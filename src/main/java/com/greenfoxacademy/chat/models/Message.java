package com.greenfoxacademy.chat.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.sql.Timestamp;

@Entity
public class Message {


  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Min(1000000)
  @Max(9999999)
  private long id;  // todo randomize the id!!!!
  @ManyToOne
  private User user;
  private String text;
  private Timestamp time;

  public Message() {
  }

  public Message(User user, String text, Timestamp time) {
    //this.user = user;
    this.text = text;
    this.time = time;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Timestamp getTime() {
    return time;
  }

  public void setTime(Timestamp time) {
    this.time = time;
  }
}
