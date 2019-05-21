package com.architecture.microservices.estudanteservice.domain.repository;

import com.architecture.microservices.estudanteservice.domain.entity.EstudanteEntity;

/**
 * Interface para inclusão de novos comportamentos de interação com o repositório.
 *
 * @author alexsrosa
 */
public interface EstudanteRepository {

    EstudanteEntity findOneByNome(String nome);
}
