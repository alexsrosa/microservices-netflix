package com.fundacred.universidadeservice.infrastruture.stream.bindings;

import com.fundacred.universidadeservice.infrastruture.dto.EstudanteDto;
import com.fundacred.universidadeservice.infrastruture.stream.channels.EstudanteCadastradoChannel;
import com.fundacred.universidadeservice.usecases.SaveOrUpdateUniversidadeUsecase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(EstudanteCadastradoChannel.class)
public class EstudanteCadastradoBinding {

    private final SaveOrUpdateUniversidadeUsecase saveOrUpdateUniversidadeUsecase;
    private Logger logger = LoggerFactory.getLogger(EstudanteCadastradoBinding.class);

    public EstudanteCadastradoBinding(SaveOrUpdateUniversidadeUsecase saveOrUpdateUniversidadeUsecase) {
        this.saveOrUpdateUniversidadeUsecase = saveOrUpdateUniversidadeUsecase;
    }

    @StreamListener(target = EstudanteCadastradoChannel.INPUT)
    public void loadEstudantes(EstudanteDto estudanteDto) {
        saveOrUpdateUniversidadeUsecase.saveOrUpdate(estudanteDto);
        logger.info(String.format("Objeto recebido: %s", estudanteDto.toString()));
    }
}
