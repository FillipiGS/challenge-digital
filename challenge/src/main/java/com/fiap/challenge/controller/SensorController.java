package com.fiap.challenge.controller;

import com.fiap.challenge.entity.Sensor;
import com.fiap.challenge.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class SensorController {

    @Autowired
    private SensorRepository sensorRepository;

    @PostMapping("/sensores")
    public ResponseEntity<Object> salvarSensor(@RequestBody Sensor sensor) {
        Sensor sensorSalvo = sensorRepository.save(sensor);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(sensorSalvo.getNumeroInstalacao()).toUri();
        return ResponseEntity.created(location).build();
    }

}
