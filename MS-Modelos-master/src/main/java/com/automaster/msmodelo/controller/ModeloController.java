package com.automaster.msmodelo.controller;


import com.automaster.msmodelo.dto.ModeloRequestDTO;
import com.automaster.msmodelo.dto.ModeloResponseDTO;
import com.automaster.msmodelo.service.ModeloService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/modelos")
@Tag(name = "Modelo", description = "Operaciones relacionadas con las Modelo")
public class ModeloController {

    @Autowired
    private ModeloService modeloService;

    @GetMapping
    @Operation(summary = "Obtener todas los modelos", description = "Obtiene una lista de todas los modelos ")
    public ResponseEntity<List<ModeloResponseDTO>> listarModelos() {
        return new ResponseEntity<>(modeloService.listarTodos(), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Crear nuevo modelo", description = "Creacion de un nuevo modelo ")
    public ResponseEntity<ModeloResponseDTO> registrarModelo(@Valid @RequestBody ModeloRequestDTO requestDTO) {
        ModeloResponseDTO nuevoModelo = modeloService.guardar(requestDTO);
        return new ResponseEntity<>(nuevoModelo, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener modelo por id ", description = "Obtiene una lista de todos los modelos por id ")
    public ResponseEntity<ModeloResponseDTO> obtenerModeloPorId(@PathVariable Long id) {
        return new ResponseEntity<>(modeloService.buscarPorId(id), HttpStatus.OK);
    }

    // --- RUTA PARA ELIMINAR MODELO ---
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar Modelo", description = "Elimina un modelo de vehículo del sistema usando su ID")
    public ResponseEntity<Void> eliminarModelo(@PathVariable Long id) {
        log.info("Petición REST DELETE entrante para eliminar el modelo ID: {}", id);
        modeloService.eliminarModelo(id);

        // HttpStatus.NO_CONTENT (204) es el código ideal para confirmar una eliminación exitosa
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}