package com.coworking.api.controller;

import com.coworking.api.model.Sala;
import com.coworking.api.dto.SalaDTO;
import com.coworking.api.service.SalaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salas")
@RequiredArgsConstructor
public class SalaController {
    private final SalaService salaService;

    @PostMapping
    public ResponseEntity<Sala> cadastar(@RequestBody @Valid SalaDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(salaService.cadastar(dto));
    }

    @GetMapping
    public ResponseEntity<List<Sala>> listar(){
        return ResponseEntity.ok(salaService.listarTodas());
    }
}
