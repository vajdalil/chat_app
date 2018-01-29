package com.greenfoxacademy.chat.repositories;

import com.greenfoxacademy.chat.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Long>{

  User findByName(String name);
}
