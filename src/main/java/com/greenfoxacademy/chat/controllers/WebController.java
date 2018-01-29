package com.greenfoxacademy.chat.controllers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.greenfoxacademy.chat.models.User;
import com.greenfoxacademy.chat.services.UserService;
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
  @JsonIgnore
  private User loggedInUser;

  @GetMapping ("/")
  public String showMainWebPage(Model model) {
    model.addAttribute("user", loggedInUser);
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
    loggedInUser = userService.login(user);
    model.addAttribute("user", loggedInUser);
    return "redirect:/";
  }
}
