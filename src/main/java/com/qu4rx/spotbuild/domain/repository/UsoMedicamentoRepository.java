package com.qu4rx.spotbuild.domain.repository;

import com.qu4rx.spotbuild.domain.entity.UsoMedicamento;

import java.time.LocalDate;
import java.util.List;

public interface UsoMedicamentoRepository {
    UsoMedicamento salvar(UsoMedicamento uso);
    List<UsoMedicamento> buscarPorUsuario(Long usuarioId);
    List<UsoMedicamento> buscarPorData(LocalDate data);
}
