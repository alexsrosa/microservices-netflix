package com.fundacred.universidadeservice.domain.repository;

import com.fundacred.universidadeservice.domain.entity.UniversidadeEntity;

public interface UniversidadeRepository {

    UniversidadeEntity findByName(String nome);
}
