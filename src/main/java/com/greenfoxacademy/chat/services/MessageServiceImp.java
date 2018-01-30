package com.greenfoxacademy.chat.services;

import com.greenfoxacademy.chat.models.webModels.Message;
import com.greenfoxacademy.chat.models.webModels.User;
import com.greenfoxacademy.chat.repositories.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImp implements MessageService{

  @Autowired
  MessageRepo messageRepo;

  @Override
  public void save(Message message, User user) {
    message.setUser(user);
    messageRepo.save(message);
  }

  @Override
  public List<Message> findAll() {
    return (List<Message>) messageRepo.findAll();
  }
}
