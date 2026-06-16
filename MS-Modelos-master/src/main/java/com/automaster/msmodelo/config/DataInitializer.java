package com.automaster.msmodelo.config;

import com.automaster.msmodelo.model.Modelo;
import com.automaster.msmodelo.repository.ModeloRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private ModeloRepository modeloRepository;

    @Override
    public void run(String... args) throws Exception {
        if (modeloRepository.count() == 0) {
            log.info("Creando marca base para pruebas...");
            Modelo Toyota = new Modelo();
            Toyota.setMarca("Toyota");
            Toyota.setNombreModelo("Yaris");
            Toyota.setMotorizacion("1.5 L");
            Toyota.setColor("Blanco");
            Toyota.setTipoCombustible("Gasolina");

            modeloRepository.save(Toyota);
            log.info("Marca 'Toyota' creada con ID 1.");
        }
    }
}
