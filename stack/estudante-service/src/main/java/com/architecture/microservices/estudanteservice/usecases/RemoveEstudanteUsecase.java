package com.architecture.microservices.estudanteservice.usecases;

import com.architecture.microservices.estudanteservice.infrastructure.services.EstudanteService;
import org.springframework.stereotype.Service;

/**
 * Classe que contêm a implementação do usecase de criação de um novo usuário.
 *
 * @author alexsrosa
 */
@Service
public class RemoveEstudanteUsecase {

    private final EstudanteService userService;

    public RemoveEstudanteUsecase(EstudanteService userService) {
        this.userService = userService;
    }

    public void deleteById(String id) {
        userService.deleteById(id);
    }
}
