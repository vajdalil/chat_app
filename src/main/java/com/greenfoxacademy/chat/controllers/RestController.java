package com.greenfoxacademy.chat.controllers;

import com.greenfoxacademy.chat.models.jsonResponds.JsonRespondMessage;
import com.greenfoxacademy.chat.models.jsonResponds.JsonRespondStatus;
import com.greenfoxacademy.chat.models.restModels.FullMessageInfo;
import com.greenfoxacademy.chat.models.webModels.User;
import com.greenfoxacademy.chat.services.MessageServiceImp;
import com.greenfoxacademy.chat.services.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.web.bind.annotation.RestController
public class RestController {

  @Autowired
  MessageServiceImp messageServiceImp;
  @Autowired
  UserServiceImp userServiceImp;

  //TODO WHAT IS @ExceptionHandler ?? WHY DO I HAVE TO USE IT??

  @ExceptionHandler(Exception.class)
  public ResponseEntity<JsonRespondStatus> exceptionHandling() {
    return  ResponseEntity.badRequest().body(new JsonRespondStatus("Error"));
  }

  //TODO WHAT IS BindingResult ?? WHY DO I HAVE TO USE IT??

  @PostMapping("/api/message/receive")
  public ResponseEntity<?> sendMessage(@RequestBody (required = false)FullMessageInfo messageInfo,
                                   BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return ResponseEntity.badRequest().body(new JsonRespondMessage("error", "Missing field(s): message.timestamp, client.id"));
    } else {
      User loggedRestUser = userServiceImp.login(messageInfo.getClient());
      messageServiceImp.save(messageInfo.getMessage(), loggedRestUser);
      return ResponseEntity.ok().body(new JsonRespondStatus("ok"));
    }
  }
}
