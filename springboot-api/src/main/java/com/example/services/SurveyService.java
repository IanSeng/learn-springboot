package com.example.services;

import com.example.model.Question;
import com.example.model.Survey;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SurveyService {
  private  static List<Survey> surveys = new ArrayList<>();
  static {
    Question question1 = new Question("Question1", "Largest Country in the world", "Russia",
      Arrays.asList("India", "Russia", "United States", "China"));
    Question question2 = new Question("Question2",
      "One of the beautiful countries in the World", "Malaysia",
      Arrays.asList("India", "Russia", "United States", "Malaysia"));
    Question question3 = new Question("Question3",
      "Highest GDP in the World", "United States",
      Arrays.asList("India", "Russia", "United States", "China"));
    Question question4 = new Question("Question4",
      "Second largest english speaking country", "India",
      Arrays.asList("India", "Russia", "United States", "China"));

    List<Question> questions = new ArrayList<>(Arrays.asList(question1,
      question2, question3, question4));

    Survey survey  = new Survey("Survey1", "My Favorite Survey",
      "Description of the Survey", questions);

    surveys.add(survey);
  }

  public  List<Survey> retrieveAllSurveys() {
    return surveys;
  }

  public Survey retrieveSurvey(String surveyId){
    for (Survey survey: surveys) {
      if (survey.getId().equals(surveyId)) {
        return survey;
      }
    }
    return null;
  }

  public List<Question> retrieveQuestions(String surveyId) {
    Survey survey = retrieveSurvey(surveyId);

    if (survey == null) {
      return null;
    }
    return survey.getQuestions();
  }
  public Question retrieveQuestion(String surveyId, String questionId) {
    Survey survey = retrieveSurvey(surveyId);

    if (survey == null) return null;

    for (Question question: survey.getQuestions()) {
      if (question.getId().equals(questionId)) {
        return question;
      }
    }
    return null;
  }

  public SecureRandom random = new SecureRandom();

  public Question addQuestion(String surveyId, Question question) {
    Survey survey = retrieveSurvey(surveyId);

    if (survey == null) {
      return null;
    }

    String randomId = new BigInteger(130, random).toString(32);
    question.setId(randomId);

    survey.getQuestions().add(question);

    return question;
  }
}
