package com.learn.firstwebapplication.controller;

  import com.learn.firstwebapplication.service.LoginService;
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.security.core.context.SecurityContextHolder;
  import org.springframework.security.core.userdetails.UserDetails;
  import org.springframework.stereotype.Controller;
  import org.springframework.ui.ModelMap;
  import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")
public class LoginController {

//  @Autowired
//  LoginService service;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String showWelcomePage(ModelMap model) {
    model.put("name", "abc");
    return "welcome";
  }

  private String getLoggedinUsername(){
    Object principal =
      SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    if(principal instanceof UserDetails){
      ((UserDetails)principal).getUsername();
    }
    return principal.toString();
  }
}
