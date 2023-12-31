package com.adroit.bmi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
    	 String errorMessage;
         if (e.getMessage().contains("weight")) {
             errorMessage = "{\"error\": \"Weight is missing\"}";
         } else if (e.getMessage().contains("height")) {
             errorMessage = "{\"error\": \"Height is missing\"}";
         } else {
             errorMessage = "{\"error\": \"" + e.getMessage() + "\"}";
         }
         return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
     
    }
}
