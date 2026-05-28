package com.coworking.api.service;

import com.coworking.api.model.Sala;
import com.coworking.api.dto.SalaDTO;
import com.coworking.api.repository.SalaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalaService {
    private final SalaRepository salaRepository;

    public Sala cadastar(SalaDTO dto){
        Sala sala = new Sala();
        sala.setNome(dto.getNome());
        sala.setTipo(dto.getTipo());
        return salaRepository.save(sala);
    }

    public List<Sala> listarTodas(){
        return salaRepository.findAll();
    }
}
