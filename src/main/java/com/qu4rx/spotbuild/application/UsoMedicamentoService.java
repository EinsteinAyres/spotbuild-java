package com.qu4rx.spotbuild.application;

import com.qu4rx.spotbuild.domain.entity.UsoMedicamento;
import com.qu4rx.spotbuild.infrastructure.persistence.UsoMedicamentoJpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class UsoMedicamentoService {

    private final UsoMedicamentoJpaRepository repo;

    public UsoMedicamentoService(UsoMedicamentoJpaRepository repo) {
        this.repo = repo;
    }

    public UsoMedicamento agendarUso(UsoMedicamento uso) {
        return repo.save(uso);
    }

    public List<UsoMedicamento> listarPorData(LocalDate data) {
        LocalDateTime inicio = data.atStartOfDay();
        LocalDateTime fim = data.atTime(LocalTime.MAX);
        return repo.findByDataHoraProgramadaBetween(inicio, fim);
    }
}
