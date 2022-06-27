package com.example.demo.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class controller {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/client")
    public String method1(){
        LOG.info("I am inside method1 of 1st microservice");
        String baseUrl = "http://localhost:8082/payment";
        String response = (String) restTemplate.exchange(baseUrl, HttpMethod.GET, null, String.class).getBody();
        LOG.info("The response received by method1 is " + response);
        return response;

    }
}
