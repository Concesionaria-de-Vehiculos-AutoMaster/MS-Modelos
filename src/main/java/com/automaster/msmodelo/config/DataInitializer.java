package com.automaster.msmodelo.config;

import com.automaster.msmodelo.model.Modelo;
import com.automaster.msmodelo.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private ModeloRepository modeloRepository;

    @Override
    public void run(String... args) throws Exception {
        if (modeloRepository.count() == 0) {
            Modelo m1 = new Modelo();
            m1.setMarca("Toyota");
            m1.setNombreModelo("Corolla");
            m1.setMotorizacion("1.8 Híbrido");
            m1.setColor("Blanco Perla");
            m1.setTipoCombustible("Híbrido");
            modeloRepository.save(m1);

            Modelo m2 = new Modelo();
            m2.setMarca("Ford");
            m2.setNombreModelo("Ranger");
            m2.setMotorizacion("2.0 Bi-Turbo");
            m2.setColor("Rojo Fuego");
            m2.setTipoCombustible("Diesel");
            modeloRepository.save(m2);

            System.out.println("Datos iniciales de MS-Modelos cargados correctamente.");
        }
    }
}