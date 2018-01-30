package com.greenfoxacademy.chat.models.webModels;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Message {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;  // todo randomize the id!!!!
  @JsonIgnore
  @ManyToOne
  private User user;
  private String text;
  private String timestamp;

  public Message() {
    this.timestamp = String.valueOf(LocalDateTime.now());
  }

  public Message(String text) {
    this.timestamp = String.valueOf(LocalDateTime.now());
    this.text = text;
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

  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }
}
