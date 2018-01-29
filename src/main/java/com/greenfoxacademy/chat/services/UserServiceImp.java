package com.greenfoxacademy.chat.services;

import com.greenfoxacademy.chat.models.User;
import com.greenfoxacademy.chat.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService{

  @Autowired
  UserRepo userRepo;

  public User login(User user) {
    List<User> users = (List<User>) userRepo.findAll();
    if (!users.contains(user)) {
      return registerArtist(user);
    }
    return userRepo.findByName(user.getName());
  }

  public User registerArtist(User user) {
    return userRepo.save(user);
  }

}
