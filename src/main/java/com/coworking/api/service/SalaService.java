package com.coworking.api.service;

import com.coworking.api.model.Sala;
import com.coworking.api.dto.SalaDTO;
import com.coworking.api.repository.SalaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.coworking.api.model.Reserva;
import com.coworking.api.model.StatusReserva;
import com.coworking.api.repository.ReservaRepository;
import java.time.LocalDate;
import java.util.stream.Collectors;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SalaService {
    private final SalaRepository salaRepository;
    private final ReservaRepository reservaRepository;
    public Sala cadastar(SalaDTO dto){
        Sala sala = new Sala();
        sala.setNome(dto.getNome());
        sala.setTipo(dto.getTipo());
        return salaRepository.save(sala);
    }

    public List<Sala> listarTodas(){
        return salaRepository.findAll();
    }

    public List<Sala> consultarSalasLivres(LocalDate data) {
        List<Sala> todasSalas = salaRepository.findAll();
        List<Reserva> reservasAtivas = reservaRepository.findByDataAndStatus(data, StatusReserva.ATIVA);

        List<Long> salasOcupadasIds = reservasAtivas.stream()
                .map(reserva -> reserva.getSala().getId())
                .distinct()
                .collect(Collectors.toList());

        return todasSalas.stream()
                .filter(sala -> !salasOcupadasIds.contains(sala.getId()))
                .collect(Collectors.toList());
    }
}
