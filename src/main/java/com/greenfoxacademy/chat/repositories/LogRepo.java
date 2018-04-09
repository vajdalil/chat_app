package com.greenfoxacademy.chat.repositories;

import com.greenfoxacademy.chat.models.webModels.Log;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepo extends CrudRepository<Log, Long> {
}
