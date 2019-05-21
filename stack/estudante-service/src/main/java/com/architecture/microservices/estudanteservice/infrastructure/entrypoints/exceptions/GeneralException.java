package com.architecture.microservices.estudanteservice.infrastructure.entrypoints.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GeneralException extends RuntimeException {

    public GeneralException(String message) {
        super(message);
    }

    public GeneralException() {
        super("Erro genérico!");
    }
}