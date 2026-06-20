package com.automaster.msmodelo.service;

import com.automaster.msmodelo.dto.ModeloRequestDTO;
import com.automaster.msmodelo.dto.ModeloResponseDTO;
import java.util.List;

public interface ModeloService {
    List<ModeloResponseDTO> listarTodos();
    ModeloResponseDTO guardar(ModeloRequestDTO requestDTO);

    ModeloResponseDTO buscarPorId(Long idModelo);
    void eliminarModelo(Long id);
}