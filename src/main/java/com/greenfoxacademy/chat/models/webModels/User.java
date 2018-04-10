package com.greenfoxacademy.chat.models.webModels;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
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

  public User(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    User user = (User) o;

    return this.getName().equals(user.getName());
  }

}
