package com.architecture.microservices.estudanteservice.infrastructure.entrypoints.converters;

import com.architecture.microservices.estudanteservice.domain.entity.EstudanteEntity;
import com.architecture.microservices.estudanteservice.infrastructure.entrypoints.dtos.EstudanteDto;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Classe de conversão da classe {@link EstudanteDto} para {@link EstudanteEntity}.
 *
 * @author alexsrosa
 */
@Component
public class EstudanteDtoToEstudanteConverter implements Converter<EstudanteDto, EstudanteEntity> {

    private final ModelMapper modelMapper;

    public EstudanteDtoToEstudanteConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public EstudanteEntity convert(EstudanteDto userDto) {
        return modelMapper.map(userDto, EstudanteEntity.class);
    }
}
