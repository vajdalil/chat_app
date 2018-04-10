package com.greenfoxacademy.chat.models.jsonResponds;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class JsonRespondMessage {

  private String status;
  private String message;

}
