package com.architecture.microservices.estudanteservice.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Classe de entidate do estudante.
 *
 * @author alexsrosa
 */
@Getter
@Setter
@Document(collection = "estudante")
public class EstudanteEntity implements Serializable {

    private static final long serialVersionUID = 9200368918942230471L;

    @Id
    private String id;

    @NotNull
    private String cpf;

    @NotNull
    private String nome;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String universidade;
}
