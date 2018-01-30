package com.greenfoxacademy.chat;

import com.greenfoxacademy.chat.models.webModels.Message;
import com.greenfoxacademy.chat.models.webModels.User;
import com.greenfoxacademy.chat.services.MessageServiceImp;
import com.greenfoxacademy.chat.services.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ChatApplication.class, args);
	}

	@Autowired
  MessageServiceImp messageServiceImp;
	@Autowired
  UserServiceImp userServiceImp;

	@Override
	public void run(String... args) throws Exception {
		User robot = new User("App");
		Message robotMessage = new Message("Hi there! Submit your messages using the send button!");
		userServiceImp.save(robot);
		messageServiceImp.save(robotMessage,robot);
	}
}
