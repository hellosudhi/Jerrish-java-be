package com.smart.inventoryM.Controller;

import org.springframework.http.HttpMessage;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ValidateController {

    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> GlobalExceptions(Exception exception)
    {
        Map<String,String> errorResponse = new HashMap<>();
        errorResponse.put("error", exception.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> messageNotReadableException(HttpMessageNotReadableException httpMessageNotReadableException) {
        Map<String,String> errorResponse = new HashMap<>();
        errorResponse.put("error", "Body Required");
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }

}
