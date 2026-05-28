package com.coworking.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "salas")

public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoSala tipo;
}
