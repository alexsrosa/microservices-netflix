package com.fundacred.universidadeservice.infrastruture.stream.channels;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface EstudanteCadastradoChannel {

    String INPUT = "estudanteCadastrado";

    @Input
    SubscribableChannel estudanteCadastrado();
}
