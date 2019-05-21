package com.architecture.microservices.estudanteservice.infrastructure.entrypoints.handler;

public class ExceptionResponse {

    private String mensagem;

    public ExceptionResponse(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
