package com.example.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.springbootapi.SpringbootApiApplication;

import java.lang.reflect.Array;
import java.util.Arrays;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes= SpringbootApiApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SurveyControllerTest {
    @LocalServerPort
    private int port;


    @Test
    void testRetreiveQuestionsForSurvey() {
      String url = "http://localhost:" + port + "/surveys/Survey1/questions/Question1";
      TestRestTemplate testRestTemplate = new TestRestTemplate();

      // Accept: application/json (content negotiation to get response in json)
      // String response = testRestTemplate.getForObject(url, String.class); this will only get us reponse in XML but we want it in json
      // HttpEntity - header
      HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

      HttpEntity entity = new HttpEntity<String>(null, headers);
      ResponseEntity<String > response = testRestTemplate.exchange(url, HttpMethod.GET, entity, String.class);
      // System.out.println("Response" + response.getBody());

      String expected = "id:Question1,description:Largest Country in the world,correctAnswer:Russia";

      try {
        JSONAssert.assertEquals(expected, response.getBody(), false);
      } catch (JSONException e) {
        e.printStackTrace();
      }


      //{"id":"Question1","description":"Largest Country in the world","correctAnswer":"Russia","options":["India","Russia","United States","China"]}
    }

    @Test
    void retreivDetailsForQuestion() {
    }

    @Test
    void addQuestionToSurvey() {
    }
}
