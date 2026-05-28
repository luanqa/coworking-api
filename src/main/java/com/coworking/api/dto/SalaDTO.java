package com.coworking.api.dto;

import com.coworking.api.model.TipoSala;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SalaDTO {
    @NotBlank(message = "O nome da sala é obrigatório")
    private String nome;

    @NotNull(message = "O tipo da sala é obrigatório")
    private TipoSala tipo;
}
