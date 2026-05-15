package com.automaster.msmodelo.dto;

import lombok.Data;

@Data
public class ModeloResponseDTO {
    private Long idModelo;
    private String marca;
    private String nombreModelo;
    private String motorizacion;
    private String color;
    private String tipoCombustible;
}