package com.learn.firstwebapplication.controller;

  import com.learn.firstwebapplication.service.LoginService;
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.stereotype.Controller;
  import org.springframework.ui.ModelMap;
  import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")
public class LoginController {

  @Autowired
  LoginService service;

  //@ResponseBody
  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public String showLoginPage(ModelMap model){
    //model.put("name", name);
    // System.out.println(name);
    // Model
    return "login";
  }

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public String showWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model){
    if (!service.validateUser(name, password)){
      model.put("errorMessage", "Invalid Credential");
      return "login";
    }
    model.put("name", name);
    model.put("password", password);
    return "welcome";
  }
}
