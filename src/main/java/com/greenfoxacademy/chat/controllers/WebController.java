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

  public final static String index= "index";
  public final static String login = "login";
  public final static String main = "/main";
  public final static String enter = "/enter";
  public final static String update = "/update";
  public final static String send = "/send";
  public final static String redirect = "redirect:";


  @Autowired
  UserService userService;
  @Autowired
  MessageService messageService;

  @JsonIgnore
  private User loggedInUser;

  @GetMapping (main)
  public String showMainWebPage(Model model, @ModelAttribute Message message) {
    if (loggedInUser == null) {
      return redirect + enter;
    }
    model.addAttribute("user", loggedInUser);
    model.addAttribute("allMessages", messageService.findAll());
    model.addAttribute("newMessage", new Message());
    return index;
  }

  @GetMapping(enter)
  public String showEnter( Model model) {
  model.addAttribute("user", new User());
  return login;
  }

  @PostMapping(enter)
  public String handleLogin(Model model, @ModelAttribute User user) {
    loggedInUser = userService.login(user);
    model.addAttribute("user", loggedInUser);
    return redirect + main;
  }

  //todo THIS IS NOT WORKING

  @PostMapping(update)
  public String updateUser(User user) {
      if(userService.findAll().contains(user)) {
        loggedInUser = user;
        return redirect + main;
      }
      return redirect + enter;
  }

  @PostMapping(send)
  public String sendMessage(@ModelAttribute Message message) {
      messageService.save(message, loggedInUser);
      return redirect + main;
  }

}
