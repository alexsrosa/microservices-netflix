package com.architecture.microservices.estudanteservice.usecases;

import com.architecture.microservices.estudanteservice.infrastructure.entrypoints.converters.EstudanteDtoToEstudanteConverter;
import com.architecture.microservices.estudanteservice.infrastructure.entrypoints.converters.EstudanteToEstudanteDtoConverter;
import com.architecture.microservices.estudanteservice.infrastructure.entrypoints.dtos.EstudanteDto;
import com.architecture.microservices.estudanteservice.domain.entity.EstudanteEntity;
import com.architecture.microservices.estudanteservice.infrastructure.services.EstudanteService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Classe que contêm a implementação do usecase de criação de um novo usuário.
 *
 * @author alexsrosa
 */
@Service
public class CriarNovoEstudanteUsecase {

    private final EstudanteService userService;
    private final EstudanteToEstudanteDtoConverter estudanteToEstudanteDtoConverter;
    private final EstudanteDtoToEstudanteConverter estudanteDtoToEstudanteConverter;

    public CriarNovoEstudanteUsecase(EstudanteService userService,
                                     EstudanteToEstudanteDtoConverter estudanteToEstudanteDtoConverter,
                                     EstudanteDtoToEstudanteConverter estudanteDtoToEstudanteConverter) {
        this.userService = userService;
        this.estudanteToEstudanteDtoConverter = estudanteToEstudanteDtoConverter;
        this.estudanteDtoToEstudanteConverter = estudanteDtoToEstudanteConverter;
    }

    public Optional<EstudanteDto> create(EstudanteDto dto) {

        Optional<EstudanteEntity> estudante = Optional.ofNullable(estudanteDtoToEstudanteConverter.convert(dto))
                .map(userService::save)
                .get();

        return estudante.map(estudanteToEstudanteDtoConverter::convert);
    }

    public Optional<EstudanteDto> put(String id, EstudanteDto estudanteDto) {

        Optional<EstudanteEntity> estudante = userService.findOne(id);

        if (estudante.isPresent()) {
            estudanteDto.setId(id);
        }

        return create(estudanteDto);

    }
}
