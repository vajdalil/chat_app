package com.greenfoxacademy.chat.services;

import com.greenfoxacademy.chat.models.User;

public interface UserService {

  User login(User user);
  User registerArtist(User user);
}
