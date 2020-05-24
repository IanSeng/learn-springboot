package com.learn.firstwebapplication.controller;

import com.learn.firstwebapplication.model.Todo;
import com.learn.firstwebapplication.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
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
    model.put("todo", new Todo(0, (String) model.getAttribute("name"), "", new Date(),
      false));
    return "todo";
  }

  @RequestMapping(value="/add-todo", method = RequestMethod.POST)
  public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
    if(result.hasErrors()){
      return "redirect:/todo";
    }
    todoService.addTodo((String) model.getAttribute("name"), todo.getDesc(), new Date(), false);
    return "redirect:/list-todos";
  }

  @RequestMapping(value="/delete-todo", method = RequestMethod.GET)
  public String deleteTodo(ModelMap model, @RequestParam int id) {
    todoService.deletedTodo(id);
    return "redirect:/list-todos";
  }
}
