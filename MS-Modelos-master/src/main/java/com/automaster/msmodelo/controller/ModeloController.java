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
@Tag(name="Garantias",description = "Venta de accesorios y piezas.")
public class ModeloController {

    @Autowired
    private ModeloService modeloService;

    @GetMapping
    @Operation(summary = "Obtener todos los modelos  ", description = "Obtiene una lista de todas los modelos  ")
    public ResponseEntity<List<ModeloResponseDTO>> listarModelos() {
        return new ResponseEntity<>(modeloService.listarTodos(), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = "Crear nuevo modelo  ", description = "Creacion de nuevos modelos  ")
    public ResponseEntity<ModeloResponseDTO> registrarModelo(@Valid @RequestBody ModeloRequestDTO requestDTO) {
        ModeloResponseDTO nuevoModelo = modeloService.guardar(requestDTO);
        return new ResponseEntity<>(nuevoModelo, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar por modelo  ", description = " Se Busca modelo por ID  ")
    public ResponseEntity<ModeloResponseDTO> obtenerModeloPorId(@PathVariable Long id) {
        return new ResponseEntity<>(modeloService.buscarPorId(id), HttpStatus.OK);
    }
}