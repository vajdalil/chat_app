package com.greenfoxacademy.chat.models.webModels;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
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

}
