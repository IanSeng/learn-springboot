package com.example.controller;

import com.example.model.Question;
import com.example.services.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class SurveyController {
  // end point url: surveys/{surveyId}/questions

  @Autowired
  private SurveyService surveyService;

  @GetMapping("/surveys/{surveyId}/questions")
  public List<Question> retreiveQuestionsForSurvey(@PathVariable String surveyId){
    return surveyService.retrieveQuestions(surveyId);
  }

  @GetMapping("/surveys/{surveyId}/questions/{questionId}")
  public Question retreivDetailsForQuestion(@PathVariable String surveyId, @PathVariable String questionId) {
    return surveyService.retrieveQuestion(surveyId, questionId);
  }

  @PostMapping("/surveys/{surveyId}/questions")
  public ResponseEntity<Void> addQuestionToSurvey(@PathVariable String surveyId, @RequestBody Question newQuestion) {
    Question question = surveyService.addQuestion(surveyId, newQuestion);

    // Handle if question does not exists
    if (question == null) {
      return ResponseEntity.noContent().build();
    }

    // URI -> /surveys/{surveyId}/questions/{questionId} question.getQuestionId()
    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
      .path("/{id}").buildAndExpand(question.getId()).toUri();

    //Status
    return ResponseEntity.created(location).build();
  }
}
