package com.architecture.microservices.estudanteservice.infrastructure.entrypoints.converters;

import com.architecture.microservices.estudanteservice.domain.entity.EstudanteEntity;
import com.architecture.microservices.estudanteservice.infrastructure.entrypoints.dtos.EstudanteDto;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe de conversão da classe {@link EstudanteDto} para {@link EstudanteEntity}.
 *
 * @author alexsrosa
 */
@Component
public class EstudanteToEstudanteDtoConverter implements Converter<EstudanteEntity, EstudanteDto> {

    private final ModelMapper modelMapper;

    public EstudanteToEstudanteDtoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public EstudanteDto convert(EstudanteEntity estudanteEntity) {
        return modelMapper.map(estudanteEntity, EstudanteDto.class);
    }

    public List<EstudanteDto> convert(List<EstudanteEntity> estudanteEntities) {

        List<EstudanteDto> estudantesDtos = new ArrayList<>();
        estudanteEntities.forEach(e -> estudantesDtos.add(convert(e)));
        return estudantesDtos;
    }
}
