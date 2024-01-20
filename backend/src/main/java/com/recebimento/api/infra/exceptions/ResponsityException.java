package com.recebimento.api.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponsityException {

    public  ResponsityException() {}

    public static ResponseEntity<String> getResponsiTyMessage(String responseMessage, HttpStatus status) {
        return ResponseEntity.status(status).body("{\"message:\""+ responseMessage + "\"}");
    }
}
