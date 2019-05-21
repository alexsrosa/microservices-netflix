package com.architecture.microservices.estudanteservice.infrastructure.stream.channels;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface EstudanteCadastradoChannel {

    String ESTUDANTE_CRIADO = "estudanteCadastrado";

    @Output(EstudanteCadastradoChannel.ESTUDANTE_CRIADO)
    SubscribableChannel estudanteCadastrado();
}
