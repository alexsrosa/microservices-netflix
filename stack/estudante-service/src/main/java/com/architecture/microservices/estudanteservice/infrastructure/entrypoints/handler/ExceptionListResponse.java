package com.architecture.microservices.estudanteservice.infrastructure.entrypoints.handler;

import java.util.List;

public class ExceptionListResponse {

    private List<String> mensagem;

    public ExceptionListResponse(List<String> mensagem) {
        this.mensagem = mensagem;
    }

    public List<String> getMensagem() {
        return mensagem;
    }
}
