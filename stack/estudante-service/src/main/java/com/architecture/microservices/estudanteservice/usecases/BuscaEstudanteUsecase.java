package com.architecture.microservices.estudanteservice.usecases;

import com.architecture.microservices.estudanteservice.infrastructure.entrypoints.converters.EstudanteToEstudanteDtoConverter;
import com.architecture.microservices.estudanteservice.infrastructure.entrypoints.dtos.EstudanteDto;
import com.architecture.microservices.estudanteservice.infrastructure.services.EstudanteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Classe que contêm a implementação do usecase para busca de um perfil existente.
 *
 * @author alexsrosa
 */
@Service
public class BuscaEstudanteUsecase {

    private final EstudanteService estudanteService;
    private final EstudanteToEstudanteDtoConverter estudanteToEstudanteDtoConverter;

    public BuscaEstudanteUsecase(EstudanteService estudanteService,
                                 EstudanteToEstudanteDtoConverter estudanteToEstudanteDtoConverter) {
        this.estudanteService = estudanteService;
        this.estudanteToEstudanteDtoConverter = estudanteToEstudanteDtoConverter;
    }

    public Optional<EstudanteDto> findOne(String id) {
        return estudanteService.findOne(id).map(estudanteToEstudanteDtoConverter::convert);

    }

    public Optional<List<EstudanteDto>> findAll() {
        return estudanteService.findAll().map(estudanteToEstudanteDtoConverter::convert);
    }
}
