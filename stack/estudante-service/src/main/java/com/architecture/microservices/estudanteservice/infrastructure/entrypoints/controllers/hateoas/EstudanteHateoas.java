package com.architecture.microservices.estudanteservice.infrastructure.entrypoints.controllers.hateoas;

import com.architecture.microservices.estudanteservice.infrastructure.entrypoints.dtos.EstudanteDto;
import com.architecture.microservices.estudanteservice.infrastructure.entrypoints.controllers.EstudanteController;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class EstudanteHateoas implements ResourceAssembler<EstudanteDto, Resource<EstudanteDto>> {

    @Override
    public Resource<EstudanteDto> toResource(EstudanteDto estudanteDto) {
        return new Resource<>(estudanteDto,
                linkTo(methodOn(EstudanteController.class).findOne(estudanteDto.getId())).withSelfRel(),
                linkTo(methodOn(EstudanteController.class).findAll()).withRel("all"),
                linkTo(methodOn(EstudanteController.class).delete(estudanteDto.getId())).withRel("delete")
        );
    }
}
