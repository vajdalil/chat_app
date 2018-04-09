package com.greenfoxacademy.chat.controllers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.greenfoxacademy.chat.models.webModels.Message;
import com.greenfoxacademy.chat.models.webModels.User;
import com.greenfoxacademy.chat.services.MessageService;
import com.greenfoxacademy.chat.services.MessageServiceImp;
import com.greenfoxacademy.chat.services.UserService;
import com.greenfoxacademy.chat.services.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {

  @Autowired
  UserService userService;
  @Autowired
  MessageService messageService;

  @JsonIgnore
  private User loggedInUser;

  @GetMapping ("/")
  public String showMainWebPage(Model model, @ModelAttribute Message message) {
    if (loggedInUser == null) {
      return "redirect:/enter";
    }
    model.addAttribute("user", loggedInUser);
    model.addAttribute("allMessages", messageService.findAll());
    model.addAttribute("newMessage", new Message());
    return "index";
  }

  @GetMapping("/enter")
  public String showEnter( Model model) {
  model.addAttribute("user", new User());
  return "enter";
  }

  @PostMapping("/enter")
  public String handleLogin(Model model, @ModelAttribute User user) {
    loggedInUser = userService.login(user);
    model.addAttribute("user", loggedInUser);
    return "redirect:/";
  }

  //todo THIS IS NOT WORKING

  @PostMapping("/update")
  public String updateUser(User user) {
      if(userService.findAll().contains(user)) {
        loggedInUser = user;
        return "redirect:/";
      }
      return "redirect:/enter";
  }

  @PostMapping("/send")
  public String sendMessage(@ModelAttribute Message message) {
      messageService.save(message, loggedInUser);
      return "redirect:/";
  }

}
