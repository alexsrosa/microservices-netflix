package com.architecture.microservices.estudanteservice.infrastructure.entrypoints.controllers;

import com.architecture.microservices.estudanteservice.infrastructure.entrypoints.controllers.hateoas.EstudanteHateoas;
import com.architecture.microservices.estudanteservice.infrastructure.entrypoints.dtos.EstudanteDto;
import com.architecture.microservices.estudanteservice.infrastructure.entrypoints.exceptions.GeneralException;
import com.architecture.microservices.estudanteservice.infrastructure.entrypoints.exceptions.UserNotFoundException;
import com.architecture.microservices.estudanteservice.usecases.BuscaEstudanteUsecase;
import com.architecture.microservices.estudanteservice.usecases.CriarNovoEstudanteUsecase;
import com.architecture.microservices.estudanteservice.usecases.RemoveEstudanteUsecase;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Classe com implementações do Endpoint de estudante.
 *
 * @author alexsrosa
 */
@RestController
@RequestMapping(value = "/estudante")
public class EstudanteController {

    private final CriarNovoEstudanteUsecase criarNovoEstudanteUsecase;
    private final BuscaEstudanteUsecase buscaEstudanteUsecase;
    private final RemoveEstudanteUsecase removeEstudanteUsecase;
    private final EstudanteHateoas estudanteResourceAssembler;

    public EstudanteController(CriarNovoEstudanteUsecase criarNovoEstudanteUsecase,
                               BuscaEstudanteUsecase buscaEstudanteUsecase,
                               RemoveEstudanteUsecase removeEstudanteUsecase,
                               EstudanteHateoas estudanteResourceAssembler) {
        this.criarNovoEstudanteUsecase = criarNovoEstudanteUsecase;
        this.buscaEstudanteUsecase = buscaEstudanteUsecase;
        this.removeEstudanteUsecase = removeEstudanteUsecase;
        this.estudanteResourceAssembler = estudanteResourceAssembler;
    }

    @ApiOperation(value = "Efetua a inclusão de um novo estudante", response = EstudanteDto.class, httpMethod = "POST")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Estudante criado com sucesso")})
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Resource<EstudanteDto>> create(@Valid @RequestBody EstudanteDto dto)
            throws URISyntaxException {

        Resource<EstudanteDto> estudanteDtoResource = criarNovoEstudanteUsecase.create(dto)
                .map(estudanteResourceAssembler::toResource)
                .orElseThrow(() -> new GeneralException("Erro ao efetuar a criação."));

        return ResponseEntity
                .created(new URI(estudanteDtoResource.getId().expand().getHref()))
                .body(estudanteDtoResource);
    }

    @ApiOperation(value = "Busca um estudante pelo identificador", response = EstudanteDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Estudante localizado com sucesso"),
            @ApiResponse(code = 404, message = "Estudante não localizado")})
    @GetMapping("/{id}")
    public ResponseEntity<EstudanteDto> findOne(@PathVariable String id) {
        return buscaEstudanteUsecase.findOne(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new UserNotFoundException("Estudante não localizado."));
    }

    @ApiOperation(value = "Busca todos os estudante", response = EstudanteDto.class, responseContainer = "List")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Sucesso!")})
    @GetMapping
    public ResponseEntity<List<EstudanteDto>> findAll() {
        return buscaEstudanteUsecase.findAll()
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new UserNotFoundException("Nenhum estudante localizado."));
    }

    @ApiOperation(value = "Atualiza ou inclusão de novo estudante", response = EstudanteDto.class, httpMethod = "PUT")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Estudantes atualizado ou criado com sucesso")})
    @PutMapping("/{id}")
    public ResponseEntity<Resource<EstudanteDto>> put(@RequestBody EstudanteDto estudanteDto, @PathVariable String id)
            throws URISyntaxException {

        Resource<EstudanteDto> estudanteDtoResource =
                criarNovoEstudanteUsecase.put(id, estudanteDto)
                        .map(estudanteResourceAssembler::toResource)
                        .orElseThrow(() -> new GeneralException("Erro ao atualizar ou inserir registro!"));

        return ResponseEntity
                .created(new URI(estudanteDtoResource.getId().expand().getHref()))
                .body(estudanteDtoResource);
    }

    @ApiOperation(value = "Efetua a exclusão do estudante", httpMethod = "DELETE")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Sucesso ao remover")})
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        removeEstudanteUsecase.deleteById(id);
        return ResponseEntity.ok().build();
    }
}