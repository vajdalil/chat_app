package com.greenfoxacademy.chat.models.webModels;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Log {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @JsonIgnore
  private long id;
  @JsonProperty("Date and Time")
  private Timestamp time;
  @JsonProperty("Log Level")
  private String level;
  @JsonProperty("Request Data")
  private String data;
  @JsonProperty("Path")
  private String endPoint;
  @JsonProperty("Method")
  private String method;

  // todo miért van a materialban kiírva az input, de nincs hozzá field???

  @JsonProperty("Input")
  private String input;

  public Log() {
  }

  public Log(Timestamp time, String level, String data, String endPoint, String method, String input) {
    this.time = time;
    this.level = level;
    this.data = data;
    this.endPoint = endPoint;
    this.method = method;
    this.input = input;
  }

  public Timestamp getTime() {
    return time;
  }

  public void setTime(Timestamp time) {
    this.time = time;
  }

  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public String getEndPoint() {
    return endPoint;
  }

  public void setEndPoint(String endPoint) {
    this.endPoint = endPoint;
  }

  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  public String getInput() {
    return input;
  }

  public void setInput(String input) {
    this.input = input;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
}
