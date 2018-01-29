package com.greenfoxacademy.chat.controllers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.greenfoxacademy.chat.models.Message;
import com.greenfoxacademy.chat.models.User;
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
  UserServiceImp userServiceImp;
  @JsonIgnore
  private User loggedInUser;

  @GetMapping ("/")
  public String showMainWebPage(Model model) {
    if (loggedInUser == null) {
      return "redirect:/enter";
    }
    model.addAttribute("user", loggedInUser);
    model.addAttribute("messages", loggedInUser.getMessages()); //todo find all text by user!!!
    return "index";
  }

  //todo LOGIN CONTROLLER

  @GetMapping("/enter")
  public String showEnter( Model model) {
  model.addAttribute("user", new User());
  return "enter";
  }

  @PostMapping("/enter")
  public String handleLogin(Model model, @ModelAttribute User user) {
    loggedInUser = userServiceImp.login(user);
    model.addAttribute("user", loggedInUser);
    return "redirect:/";
  }

  @PostMapping("/send")
  public String sendMessage(Model model, @ModelAttribute User user, @ModelAttribute Message message) {
    model.addAttribute("message", );  // todo ide pedig a messages
    return "redirect:/";
  }


}
