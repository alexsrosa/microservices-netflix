package com.architecture.microservices.estudanteservice.infrastructure.services;

import com.architecture.microservices.estudanteservice.infrastructure.database.repositories.EstudanteMongoRepository;
import com.architecture.microservices.estudanteservice.domain.entity.EstudanteEntity;
import com.architecture.microservices.estudanteservice.infrastructure.stream.channels.EstudanteCadastradoChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Classe de serviço do usuário.
 *
 * @author alexsrosa
 */
@Service
public class EstudanteService {

    private final EstudanteMongoRepository estudanteMongoRepository;
    private final EstudanteCadastradoChannel estudanteCadastradoChannel;

    public EstudanteService(EstudanteMongoRepository estudanteMongoRepository,
                            EstudanteCadastradoChannel estudanteCadastradoChannel) {
        this.estudanteMongoRepository = estudanteMongoRepository;
        this.estudanteCadastradoChannel = estudanteCadastradoChannel;
    }

    /**
     * Método que efetua a criação de um novo usuário.
     *
     * @param estudante objeto do tipo {@link EstudanteEntity}
     * @return retorna um {@link Optional} de {@link EstudanteEntity}
     */
    public Optional<EstudanteEntity> save(EstudanteEntity estudante) {
        Optional<EstudanteEntity> estudanteSaved = Optional.ofNullable(estudanteMongoRepository.save(estudante));

        estudanteCadastradoChannel.estudanteCadastrado()
                .send(MessageBuilder.withPayload(estudante).build());

        return estudanteSaved;
    }

    public Optional<EstudanteEntity> findOne(String id) {
        return estudanteMongoRepository.findById(id);
    }

    public Optional<List<EstudanteEntity>> findAll() {
        return Optional.ofNullable(estudanteMongoRepository.findAll());
    }

    public void deleteById(String id) {
        estudanteMongoRepository.deleteById(id);
    }
}
