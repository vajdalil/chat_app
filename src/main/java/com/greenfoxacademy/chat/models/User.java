package com.greenfoxacademy.chat.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @JsonIgnore
  private long id;
  @JsonProperty("Username")
  private String name;
  @OneToMany
  (cascade = CascadeType.ALL,
  orphanRemoval = true,
  mappedBy = "user")
  @JsonProperty("Message")
  private List<Message> messages;

  public User() {
  }

  public User(String name) {
    this.name = name;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Message> getMessages() {
    return messages;
  }

  public void setMessages(List<Message> messages) {
    this.messages = messages;
  }

  //todo override equals method
}
