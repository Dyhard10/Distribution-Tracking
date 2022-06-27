package com.example.demo.Controller;

import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class controller {
    @Autowired
    RestTemplate restTemplate;
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());
    @GetMapping("/payment")
    public String payment(){
        LOG.info("I am inside bankservice inside of 2nd microservice");
        String baseUrl1 = "http://localhost:8083/bank1";
        String response1 = (String) restTemplate.exchange(baseUrl1, HttpMethod.GET, null, String.class).getBody();
        //LOG.info("The response received by method1 is " + response1);

        String baseUrl2 = "http://localhost:8083/bank2";
        String response2 = (String) restTemplate.exchange(baseUrl2, HttpMethod.GET, null, String.class).getBody();
        //LOG.info("The response received by method1 is " + response2);

        String baseUrl3 = "http://localhost:8083/bank3";
        String response3 = (String) restTemplate.exchange(baseUrl3, HttpMethod.GET, null, String.class).getBody();
        LOG.info("The response received by method1 is " + response1+response2+response3);
        String response = response1+response2+response3;
        return response;
    }
}
