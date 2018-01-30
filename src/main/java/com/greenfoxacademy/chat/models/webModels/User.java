package com.greenfoxacademy.chat.models.webModels;

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

  @JsonProperty("id")
  private String name;

  @JsonIgnore
  @JsonProperty("Messages")
  @OneToMany
  (cascade = CascadeType.ALL,
  fetch = FetchType.EAGER,
  orphanRemoval = true,
  mappedBy = "user")
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    User user = (User) o;

    return this.getName().equals(user.getName());
  }

}
