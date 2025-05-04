package com.qu4rx.spotbuild.infrastructure.persistence;

import com.qu4rx.spotbuild.domain.entity.UsoMedicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface UsoMedicamentoJpaRepository extends JpaRepository<UsoMedicamento, Long> {
    List<UsoMedicamento> findByDataHoraProgramadaBetween(LocalDateTime inicio, LocalDateTime fim);
}
