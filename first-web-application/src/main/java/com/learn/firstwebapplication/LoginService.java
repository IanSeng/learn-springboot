package com.learn.firstwebapplication;

import org.springframework.stereotype.Component;

@Component
public class LoginService {

  public boolean validateUser(String userId, String password){
    return userId.equalsIgnoreCase("abc") &&
      password.equalsIgnoreCase("abc");
  }
}
