package com.recebimento.api.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseEntityException extends Exception{

    public ResponseEntityException() {}

    public static ResponseEntity<String> getResponseEntityMessage(String responseMessage, HttpStatus status) {
        return ResponseEntity.status(status).body("{\"message:\""+ responseMessage + "\"}");
    }
    public static void getException(String responseMessage) throws Exception {
        throw new Exception("{\"message:\""+ responseMessage + "\"}");
    }
}
