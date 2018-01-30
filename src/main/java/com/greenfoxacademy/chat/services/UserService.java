package com.greenfoxacademy.chat.services;

import com.greenfoxacademy.chat.models.webModels.User;

import java.util.List;

public interface UserService {

  User login(User user);
  User registerUser(User user);
  List <User> findAll();
  User findById(Long userId);
  User save(User user);
  User update(User user);
}
