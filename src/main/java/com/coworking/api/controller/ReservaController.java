package com.coworking.api.controller;

import com.coworking.api.dto.ReservaDTO;
import com.coworking.api.model.Reserva;
import com.coworking.api.service.ReservaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reservas")
@RequiredArgsConstructor
public class ReservaController {

    private final ReservaService reservaService;

    @PostMapping
    public ResponseEntity<Reserva> criar(@RequestBody @Valid ReservaDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reservaService.criar(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelar(@PathVariable Long id) {
        reservaService.cancelar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/agenda")
    public ResponseEntity<List<Reserva>> agendaDiaria(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {
        return ResponseEntity.ok(reservaService.consultarAgendaDiaria(data));
    }
}