package com.learn.firstwebapplication.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {

  public boolean validateUser(String userId, String password){
    return userId.equalsIgnoreCase("abc2") &&
      password.equalsIgnoreCase("abc2");
  }
}
