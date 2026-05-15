package com.automaster.msmodelo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ModeloRequestDTO {

    @NotBlank(message = "La marca es obligatoria")
    private String marca;

    @NotBlank(message = "El nombre del modelo es obligatorio")
    private String nombreModelo;

    @NotBlank(message = "La motorización es obligatoria")
    private String motorizacion;

    @NotBlank(message = "El color es obligatorio")
    private String color;

    @NotBlank(message = "El tipo de combustible es obligatorio")
    private String tipoCombustible;
}