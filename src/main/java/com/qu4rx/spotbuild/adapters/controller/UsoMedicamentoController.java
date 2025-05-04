package com.qu4rx.spotbuild.adapters.controller;

import com.qu4rx.spotbuild.application.UsoMedicamentoService;
import com.qu4rx.spotbuild.domain.entity.UsoMedicamento;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/uso-medicamento")
public class UsoMedicamentoController {

    private final UsoMedicamentoService service;

    public UsoMedicamentoController(UsoMedicamentoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UsoMedicamento> agendar(@RequestBody UsoMedicamento uso) {
        return ResponseEntity.ok(service.agendarUso(uso));
    }

    @GetMapping("/por-data")
    public ResponseEntity<List<UsoMedicamento>> listarPorData(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {
        return ResponseEntity.ok(service.listarPorData(data));
    }
}

