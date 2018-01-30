package com.greenfoxacademy.chat.models.restModels;

import com.greenfoxacademy.chat.models.webModels.Message;
import com.greenfoxacademy.chat.models.webModels.User;

public class FullMessageInfo {

  private Message message;
  private User client;

  public FullMessageInfo() {
  }

  public FullMessageInfo(Message message, User client) {
    this.message = message;
    this.client = client;
  }

  public Message getMessage() {
    return message;
  }

  public void setMessage(Message message) {
    this.message = message;
  }

  public User getClient() {
    return client;
  }

  public void setClient(User client) {
    this.client = client;
  }
}
