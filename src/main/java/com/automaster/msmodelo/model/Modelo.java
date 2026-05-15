package com.automaster.msmodelo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "modelos")
@Data
public class Modelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idModelo;

    @NotBlank(message = "La marca es obligatoria")
    private String marca; // Ej: Toyota, Ford

    @NotBlank(message = "El nombre del modelo es obligatorio")
    private String nombreModelo; // Ej: Corolla, Ranger

    @NotBlank(message = "La motorización es obligatoria")
    private String motorizacion; // Ej: 1.8 Híbrido, 2.0 Turbo

    @NotBlank(message = "El color es obligatorio")
    private String color;

    @NotBlank(message = "El tipo de combustible es obligatorio")
    private String tipoCombustible; // Ej: Gasolina, Diesel, Eléctrico
}