package com.greenfoxacademy.chat.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

  @GetMapping ("/")
  public String showMainWebPage() {
    return "index";
  }

}
