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
    @GetMapping("/bank1")
    public String method1(){
        LOG.info("In the 3rd Microservice");
        String baseUrl = "http://localhost:8084/userdetail";
        String response = (String) restTemplate.exchange(baseUrl, HttpMethod.GET, null, String.class).getBody();
        LOG.info("The response received by method1 is " + response);
        return response;
    }

    @GetMapping("/bank2")
    public String method2(){
        LOG.info("In the 3rd Microservice");
        String baseUrl = "http://localhost:8084/userdetail";
        String response = (String) restTemplate.exchange(baseUrl, HttpMethod.GET, null, String.class).getBody();
        LOG.info("The response received by method2 is " + response);
        return response;
    }
    @GetMapping("/bank3")
    public String method3(){
        LOG.info("In the 3rd Microservice");
        String baseUrl = "http://localhost:8084/userdetail";
        String response = (String) restTemplate.exchange(baseUrl, HttpMethod.GET, null, String.class).getBody();
        LOG.info("The response received by method3 is " + response);
        return response;
    }
}
