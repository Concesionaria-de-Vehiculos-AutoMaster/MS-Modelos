package com.automaster.msmodelo.controller;

import com.automaster.msmodelo.dto.ModeloRequestDTO;
import com.automaster.msmodelo.dto.ModeloResponseDTO;
import com.automaster.msmodelo.service.ModeloService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/modelos")
public class ModeloController {

    @Autowired
    private ModeloService modeloService;

    @GetMapping
    public ResponseEntity<List<ModeloResponseDTO>> listarModelos() {
        return new ResponseEntity<>(modeloService.listarTodos(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ModeloResponseDTO> registrarModelo(@Valid @RequestBody ModeloRequestDTO requestDTO) {
        ModeloResponseDTO nuevoModelo = modeloService.guardar(requestDTO);
        return new ResponseEntity<>(nuevoModelo, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModeloResponseDTO> obtenerModeloPorId(@PathVariable Long id) {
        return new ResponseEntity<>(modeloService.buscarPorId(id), HttpStatus.OK);
    }
}