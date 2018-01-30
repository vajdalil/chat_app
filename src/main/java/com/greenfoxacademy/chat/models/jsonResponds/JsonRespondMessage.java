package com.greenfoxacademy.chat.models.jsonResponds;

public class JsonRespondMessage {

  private String status;
  private String message;

  public JsonRespondMessage() {
  }

  public JsonRespondMessage(String status, String message) {
    this.status = status;
    this.message = message;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
