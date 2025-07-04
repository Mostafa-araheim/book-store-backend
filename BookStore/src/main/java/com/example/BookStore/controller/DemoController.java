package com.example.BookStore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/demo-controller")
public class DemoController {
    @GetMapping
    public ResponseEntity<Map<String, String>> sayHello()
    {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello from secured endpoint");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
