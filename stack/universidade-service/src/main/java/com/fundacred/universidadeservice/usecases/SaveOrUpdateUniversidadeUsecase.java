package com.fundacred.universidadeservice.usecases;

import com.fundacred.universidadeservice.domain.entity.UniversidadeEntity;
import com.fundacred.universidadeservice.infrastruture.dto.EstudanteDto;
import com.fundacred.universidadeservice.infrastruture.services.UniversidadeService;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SaveOrUpdateUniversidadeUsecase {

    private final UniversidadeService universidadeService;

    public SaveOrUpdateUniversidadeUsecase(UniversidadeService universidadeService) {
        this.universidadeService = universidadeService;
    }

    public void saveOrUpdate(EstudanteDto estudanteDto) {

        Optional<UniversidadeEntity> universidade = universidadeService.findByName(estudanteDto.getUniversidade());

        UniversidadeEntity universidadeEntity;

        if (universidade.isPresent()) {
            universidadeEntity = universidade.get();
            universidadeEntity.plusEstudantes();
        } else {
            universidadeEntity = new UniversidadeEntity();
            universidadeEntity.setName(estudanteDto.getUniversidade());
            universidadeEntity.setNumEstudantes(1);
        }
        universidadeService.save(universidadeEntity);
    }
}
