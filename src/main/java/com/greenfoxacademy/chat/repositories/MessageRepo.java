package com.greenfoxacademy.chat.repositories;

import com.greenfoxacademy.chat.models.webModels.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepo extends CrudRepository<Message, Long>{

}
