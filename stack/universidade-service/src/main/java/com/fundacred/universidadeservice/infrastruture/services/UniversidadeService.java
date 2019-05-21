package com.fundacred.universidadeservice.infrastruture.services;

import com.fundacred.universidadeservice.domain.entity.UniversidadeEntity;
import com.fundacred.universidadeservice.infrastruture.database.repositories.UniversidadeJpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UniversidadeService {

    private final UniversidadeJpaRepository repository;

    public UniversidadeService(UniversidadeJpaRepository repository) {
        this.repository = repository;
    }

    public void save(UniversidadeEntity universidadeEntity) {
        repository.save(universidadeEntity);
    }

    public Optional<UniversidadeEntity> findByName(String nome) {
        return Optional.ofNullable(repository.findByName(nome));
    }
}
