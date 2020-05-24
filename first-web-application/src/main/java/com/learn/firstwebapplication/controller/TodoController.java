package com.learn.firstwebapplication.controller;

import com.learn.firstwebapplication.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Date;

@Controller
@SessionAttributes("name")
public class TodoController {

  @Autowired
  TodoService todoService;

  @RequestMapping(value="/list-todos", method = RequestMethod.GET)
  public String showListTodos(ModelMap model) {
    String name = (String) model.getAttribute("name");
    model.put("todos", todoService.retrieveTodos(name));
    return "list-todos";
  }

  @RequestMapping(value="/add-todo", method = RequestMethod.GET)
  public String showAddTodoPage(ModelMap model) {
    return "todo";
  }

  @RequestMapping(value="/add-todo", method = RequestMethod.POST)
  public String addTodo(ModelMap model, @RequestParam String desc) {
    todoService.addTodo((String) model.getAttribute("name"), desc, new Date(), false);
    return "redirect:/list-todos";
  }

  @RequestMapping(value="/delete-todo", method = RequestMethod.GET)
  public String deleteTodo(ModelMap model, @RequestParam int id) {
    todoService.deletedTodo(id);
    return "redirect:/list-todos";
  }
}
