package com.qu4rx.spotbuild.domain.entity;

import com.qu4rx.spotbuild.domain.enums.ViaAdministracao;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class UsoMedicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String medicamento;

    private String dose;

    @Enumerated(EnumType.STRING)
    private ViaAdministracao via;

    private LocalDateTime dataHoraProgramada;

    private LocalDateTime dataHoraExecutada;

    private String observacoes;

    // Getters, setters, equals, hashCode
}
