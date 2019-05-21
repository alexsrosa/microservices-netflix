package com.architecture.microservices.estudanteservice.infrastructure.database.repositories;

import com.architecture.microservices.estudanteservice.domain.entity.EstudanteEntity;
import com.architecture.microservices.estudanteservice.domain.repository.EstudanteRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface de repositório da entidade {@link EstudanteEntity}.
 *
 * @author alexsrosa
 */
@Repository
public interface EstudanteMongoRepository
        extends MongoRepository<EstudanteEntity, String>, EstudanteRepository {

}
