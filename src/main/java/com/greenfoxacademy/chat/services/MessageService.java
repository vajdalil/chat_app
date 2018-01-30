package com.greenfoxacademy.chat.services;

import com.greenfoxacademy.chat.models.webModels.Message;
import com.greenfoxacademy.chat.models.webModels.User;

import java.util.List;

public interface MessageService {

  void save(Message message, User user);
  List <Message> findAll();
}
