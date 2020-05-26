package com.example.springbootcamp.dao;

import com.example.springbootcamp.modal.Person;

import java.util.UUID;

public interface PersonDao {

  int insertPerson(UUID id, Person Person);

  default int insertPerson(Person person){
    UUID id = UUID.randomUUID();
    return insertPerson(id, person);
  }
}
