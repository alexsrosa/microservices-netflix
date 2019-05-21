package com.fundacred.universidadeservice.infrastruture.database.repositories;

import com.fundacred.universidadeservice.domain.entity.UniversidadeEntity;
import com.fundacred.universidadeservice.domain.repository.UniversidadeRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversidadeJpaRepository
        extends JpaRepository<UniversidadeEntity, Long>, UniversidadeRepository {
}
