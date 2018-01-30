package com.greenfoxacademy.chat.services;

import com.greenfoxacademy.chat.models.webModels.User;
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
      return registerUser(user);
    }
    return userRepo.findByName(user.getName());
  }

  public User registerUser(User user) {
    return userRepo.save(user);
  }

  @Override
  public List<User> findAll() {
    return (List<User>) userRepo.findAll();
  }

  @Override
  public User findById(Long userId) {
    return userRepo.findOne(userId);
  }

  @Override
  public User save(User user) {
   return userRepo.save(user);
  }

  @Override
  public User update(User updatedUser) {
    User oldUser = findById(updatedUser.getId());
    oldUser.setName(updatedUser.getName());
    return save(oldUser);
  }
}
