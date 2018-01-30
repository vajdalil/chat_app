package com.greenfoxacademy.chat.models.jsonResponds;

public class JsonRespondStatus {

  private String status;

  public JsonRespondStatus() {
  }

  public JsonRespondStatus(String status) {
    this.status = status;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
