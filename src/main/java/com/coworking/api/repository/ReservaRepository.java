package com.coworking.api.repository;

import com.coworking.api.model.Reserva;
import com.coworking.api.model.StatusReserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    List<Reserva> findBySalaIdAndDataAndStatus(Long salaId, LocalDate data, StatusReserva status);
    List<Reserva> findByDataAndStatus(LocalDate data, StatusReserva status);
}

