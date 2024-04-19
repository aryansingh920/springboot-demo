package com.example.springbootdemo.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.springbootdemo.types.InputController;

@Component
public class InputClientImpl implements InputController {

    private final String INPUT_URL = "http://localhost:8080/input";
    private final RestTemplate restTemplate;

    public InputClientImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ResponseEntity<String> sendInput(String input) {
        ResponseEntity<String> response = restTemplate.postForEntity(INPUT_URL, input, String.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Input sent successfully!");
        } else {
            System.err.println("Failed to send input!");
        }
        return response;
    }
}
