package com.recebimento.api.web.controllers;

import com.recebimento.api.infra.exceptions.ResponseEntityException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFoundException(Exception ex) {return ex.getMessage();}

    @ExceptionHandler(ResponseEntityException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<String> handleConstraintViolationException(ResponseEntityException e) {
        return ResponseEntityException.getResponseEntityMessage("not valid due to validation error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
