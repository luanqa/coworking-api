package com.coworking.api.service;

import com.coworking.api.dto.ReservaDTO;
import com.coworking.api.model.Reserva;
import com.coworking.api.model.StatusReserva;
import com.coworking.api.repository.ReservaRepository;
import com.coworking.api.repository.SalaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservaService {
    private final ReservaRepository reservaRepository;
    private final SalaRepository salaRepository;

    public Reserva criar(ReservaDTO dto){
        var sala = salaRepository.findById(dto.getSalaId()).orElseThrow(() -> new RuntimeException("Sala não encontrada"));
        validarConflito(dto);

        Reserva reserva = new Reserva();
        reserva.setSala(sala);
        reserva.setResponsavel(dto.getResponsavel());
        reserva.setData(dto.getData());
        reserva.setHoraInicio(dto.getHoraInicio());
        reserva.setHoraFim(dto.getHoraFim());
        reserva.setStatus(StatusReserva.ATIVA);
        return reservaRepository.save(reserva);
    }

    public void cancelar(Long id) {
        Reserva reserva = reservaRepository.findById(id).orElseThrow(() -> new RuntimeException("Reserva não encontrada"));
        reserva.setStatus(StatusReserva.CANCELADA);
        reservaRepository.save(reserva);
    }

    private void validarConflito(ReservaDTO dto){

        List<Reserva> reservasExistentes = reservaRepository.findBySalaIdAndDataAndStatus(dto.getSalaId(), dto.getData(), StatusReserva.ATIVA);
        for(Reserva reserva : reservasExistentes){
            boolean conflito = dto.getHoraInicio().isBefore(reserva.getHoraFim()) && dto.getHoraFim().isAfter(reserva.getHoraInicio());
            if(conflito){
                throw new RuntimeException("CONFLITO DE HORÁRIO: A sala já está reservada para o período");
            }
        }
    }

    public List<Reserva> consultarAgendaDiaria(java.time.LocalDate data) {
        return reservaRepository.findByDataAndStatus(data, StatusReserva.ATIVA);
    }
}
