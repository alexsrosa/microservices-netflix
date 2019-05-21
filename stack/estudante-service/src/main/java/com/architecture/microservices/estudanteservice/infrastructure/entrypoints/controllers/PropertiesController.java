package com.architecture.microservices.estudanteservice.infrastructure.entrypoints.controllers;

import com.architecture.microservices.estudanteservice.infrastructure.configuration.PropertiesConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 * Classe com implementações do Endpoint de properties.
 *
 * @author alexsrosa
 */
@RestController
@RefreshScope
@RequestMapping(value = "/properties")
public class PropertiesController {

    @Value("${estudante.prop}")
    String value;

    @Autowired
    private PropertiesConfiguration properties;


    @GetMapping("/getConfigFromValue")
    public String getConfigFromValue() {
        return value;
    }

    @GetMapping("/getConfigFromProperty")
    public String getConfigFromProperty() {
        return properties.getProp();
    }
}