package com.architecture.microservices.estudanteservice.infrastructure.stream.bindings;


import com.architecture.microservices.estudanteservice.infrastructure.stream.channels.EstudanteCadastradoChannel;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(EstudanteCadastradoChannel.class)
public class EstudanteCadastradoBinding {

}
