package com.example.controller;

import com.example.model.Question;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.springbootapi.SpringbootApiApplication;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes= SpringbootApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SurveyControllerTest {
    @LocalServerPort
    private int port;

    HttpHeaders headers = new HttpHeaders();
    @BeforeEach
    public void before (){
      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

    }

    @Test
    void testretreiveDetailsForQuestion(){
      String urlToRetreiveAQuestion = urlPort("/surveys/Survey1/questions/Question1");
      TestRestTemplate testRestTemplate = new TestRestTemplate();

      // Accept: application/json (content negotiation to get response in json)
      // String response = testRestTemplate.getForObject(url, String.class); this will only get us reponse in XML but we want it in json
      // HttpEntity - header
      //HttpHeaders headers = new HttpHeaders();
      //headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

      HttpEntity entity = new HttpEntity<String>(null, headers);
      ResponseEntity<String > response = testRestTemplate.exchange(urlToRetreiveAQuestion, HttpMethod.GET, entity, String.class);
      // System.out.println("Response" + response.getBody());

      String expected = "{id:Question1,description:Largest Country in the World,correctAnswer:Russia}";
      try {
        JSONAssert.assertEquals(expected, response.getBody(), false);
      } catch (JSONException e) {
        e.printStackTrace();
      }


      //{"id":"Question1","description":"Largest Country in the world","correctAnswer":"Russia","options":["India","Russia","United States","China"]}
    }

//    @Test
//    public void testRetreiveQuestionsForSurvey() {
//      String url = "http://localhost:" + port + "/surveys/Survey1/questions";
//      TestRestTemplate testRestTemplate = new TestRestTemplate();
//      HttpHeaders headers = new HttpHeaders();
//      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//      HttpEntity entity = new HttpEntity<String>(null, headers);
//
//      ResponseEntity<List<Question>> response = testRestTemplate.exchange(
//        url,
//        HttpMethod.GET,
//        entity,
//        new ParameterizedTypeReference<List<Question>>(){}); // ParameterizedTypeReference (4th param) is the controller class type
//
//      Question sampleQuestion = new Question("Question1", "Largest Country in the world", "Russia",
//        Arrays.asList("India", "Russia", "United States", "China"));
//
//      assertTrue(response.getBody().contains(sampleQuestion));
//    }


    @Test
    void testAddQuestionToSurvey() {
      String urlToAddAQuestion = urlPort("/surveys/Survey1/questions");
      TestRestTemplate testRestTemplate = new TestRestTemplate();

      Question testQuestion = new Question("testQuestion", "Largest Country in the world", "Russia",
        Arrays.asList("India", "Russia", "United States", "China"));

      HttpEntity entity = new HttpEntity<Question>(testQuestion, headers);
      ResponseEntity<String > response = testRestTemplate.exchange(urlToAddAQuestion, HttpMethod.POST, entity, String.class);

      String actualHeaderLocationResponse = response.getHeaders().get(HttpHeaders.LOCATION).get(0);

      assertTrue(actualHeaderLocationResponse.contains("/surveys/Survey1/questions/"));
    }

    public String urlPort (String url) {
      return "http://localhost:" + port + url;
    }
}
