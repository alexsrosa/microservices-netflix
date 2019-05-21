package com.architecture.microservices.estudanteservice.infrastructure.entrypoints.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * Classe de transferência de dados do login.
 *
 * @author <a href="mailto:alexsros@gmail.com">Alex S. Rosa</a>
 * @since 18/12/2018 13:41:23
 */
@Getter
@Setter
public class EstudanteDto {

    private String id;

    @NotBlank(message = "Campo cpf deve ser informado.")
    private String cpf;

    @NotBlank(message = "Campo nome deve ser informado.")
    private String nome;

    @NotBlank(message = "Campo email deve ser informado.")
    @Email
    private String email;

    @NotBlank(message = "Campo universidade deve ser informado.")
    private String universidade;
}
