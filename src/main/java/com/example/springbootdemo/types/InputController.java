package com.example.springbootdemo.types;

import org.springframework.http.ResponseEntity;

public interface InputController {
    ResponseEntity<String> sendInput(String input);
}
