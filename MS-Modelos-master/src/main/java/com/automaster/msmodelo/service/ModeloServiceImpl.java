package com.automaster.msmodelo.service;

import com.automaster.msmodelo.dto.ModeloRequestDTO;
import com.automaster.msmodelo.dto.ModeloResponseDTO;
import com.automaster.msmodelo.model.Modelo;
import com.automaster.msmodelo.repository.ModeloRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
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
    // --- MÉTODO PARA ELIMINAR MODELO ---
    public void eliminarModelo(Long id) {
        log.info("Iniciando proceso para eliminar modelo con ID: {}", id);

        // Validamos si existe antes de intentar borrarlo
        if (!modeloRepository.existsById(id)) {
            log.error("Error al eliminar: No se encontró modelo con ID {}", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El modelo con el ID indicado no existe.");
        }

        // Si existe, lo eliminamos
        modeloRepository.deleteById(id);
        log.info("Modelo con ID {} eliminado exitosamente", id);
    }

}