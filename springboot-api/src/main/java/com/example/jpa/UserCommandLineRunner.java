package com.example.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserCommandLineRunner implements CommandLineRunner {

  private static final Logger log = LoggerFactory
    .getLogger(UserCommandLineRunner.class);

  @Autowired
  private UserRepository repository;

  @Override
  public void run(String... args) {
    // save a couple of customers
    repository.save(new User("admin", "admin"));
    repository.save(new User("abc", "abc"));
    repository.save(new User("asd", "asd"));
    log.info("-------------------------------");
    log.info("Finding all users");
    log.info("-------------------------------");
    for (User user : repository.findByRole("admin")) {
      log.info(user.toString());
    }

  }

}
