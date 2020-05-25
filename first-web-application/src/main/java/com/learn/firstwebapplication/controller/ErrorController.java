package com.learn.firstwebapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller("error")
public class ErrorController {

  @ExceptionHandler(Exception.class)
  public ModelAndView handleException(HttpServletResponse response, HttpServletRequest request){
    ModelAndView mv = new ModelAndView();
   // mv.addObject("exception", handleException().getStackTrace());
    mv.addObject("url", request.getRequestURL());
    mv.setViewName("error");
    return mv;

  }
}
