package com.coworking.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ReservaDTO {
    @NotNull(message = "O código da sala é obrigatório")
    private  Long salaId;

    @NotNull(message = "O responsavel da sala é obrigatório")
    private String responsavel;

    @NotNull(message = "A data é obrigatória")
    private LocalDate data;

    @NotNull(message = "A hora incial é obrigatória")
    private LocalTime horaInicio;

    @NotNull(message = "A hora final é obrigatória")
    private LocalTime horaFim;
}
