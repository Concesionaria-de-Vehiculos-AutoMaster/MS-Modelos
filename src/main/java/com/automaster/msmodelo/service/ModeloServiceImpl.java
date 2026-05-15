package com.automaster.msmodelo.service;

import com.automaster.msmodelo.dto.ModeloRequestDTO;
import com.automaster.msmodelo.dto.ModeloResponseDTO;
import com.automaster.msmodelo.model.Modelo;
import com.automaster.msmodelo.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModeloServiceImpl implements ModeloService {

    @Autowired
    private ModeloRepository modeloRepository;

    @Override
    public List<ModeloResponseDTO> listarTodos() {
        return modeloRepository.findAll()
                .stream()
                .map(this::convertirAResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ModeloResponseDTO guardar(ModeloRequestDTO requestDTO) {
        Modelo modelo = convertirAEntidad(requestDTO);
        Modelo modeloGuardado = modeloRepository.save(modelo);
        return convertirAResponseDTO(modeloGuardado);
    }

    private ModeloResponseDTO convertirAResponseDTO(Modelo modelo) {
        ModeloResponseDTO dto = new ModeloResponseDTO();
        dto.setIdModelo(modelo.getIdModelo());
        dto.setMarca(modelo.getMarca());
        dto.setNombreModelo(modelo.getNombreModelo());
        dto.setMotorizacion(modelo.getMotorizacion());
        dto.setColor(modelo.getColor());
        dto.setTipoCombustible(modelo.getTipoCombustible());
        return dto;
    }

    private Modelo convertirAEntidad(ModeloRequestDTO dto) {
        Modelo modelo = new Modelo();
        modelo.setMarca(dto.getMarca());
        modelo.setNombreModelo(dto.getNombreModelo());
        modelo.setMotorizacion(dto.getMotorizacion());
        modelo.setColor(dto.getColor());
        modelo.setTipoCombustible(dto.getTipoCombustible());
        return modelo;
    }

    @Override
    public ModeloResponseDTO buscarPorId(Long idModelo) {
        Modelo modelo = modeloRepository.findById(idModelo)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Modelo no encontrado"));
        return convertirAResponseDTO(modelo);
    }
}