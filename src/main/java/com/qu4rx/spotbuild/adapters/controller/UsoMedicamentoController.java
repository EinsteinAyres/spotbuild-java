package com.qu4rx.spotbuild.adapters.controller;


// Importa o serviço de aplicação responsável pela lógica de negócio relacionada ao uso de medicamentos.
import com.qu4rx.spotbuild.application.UsoMedicamentoService;

// Importa a entidade de domínio que representa o uso de medicamento.
import com.qu4rx.spotbuild.domain.entity.UsoMedicamento;

// Importações do Spring para formatação de datas, respostas HTTP, validação e anotações de controller.
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

/**
 * Controller REST responsável por expor endpoints relacionados ao uso de medicamentos.
 * - @RestController: indica que esta classe é um controller REST, ou seja, retorna dados no formato JSON.
 * - @RequestMapping: define o caminho base para todos os endpoints deste controller.
 * - @RequiredArgsConstructor: Lombok cria um construtor injetando automaticamente as dependências finais.
 * - @Validated: habilita a validação automática dos parâmetros e do corpo das requisições.
 */

@RestController // Marca a classe como um controller REST do Spring.
@RequestMapping("/api/uso-medicamento") // Define o prefixo dos endpoints deste controller.
//@RequiredArgsConstructor // Lombok: gera construtor com os campos finais (injeção de dependência).
//@Validated // Habilita validação automática dos parâmetros e do corpo das requisições.


public class UsoMedicamentoController {

    // Injeção do serviço de aplicação responsável pela lógica de uso de medicamentos.
    // O Spring injeta automaticamente uma instância de UsoMedicamentoService.

    private final UsoMedicamentoService service;

    public UsoMedicamentoController(UsoMedicamentoService service) {
        this.service = service;
    }

    /**
     * Endpoint para agendar (criar) um novo uso de medicamento.
     * - @PostMapping: Mapeia requisições HTTP POST para este método.
     * - @RequestBody: Indica que o objeto UsoMedicamento será recebido no corpo da requisição.
     * - @Validated: Garante que as validações da entidade serão aplicadas.
     *
     * @param uso Objeto UsoMedicamento recebido no corpo da requisição.
     * @return ResponseEntity com status 201 (Created) e o objeto criado no corpo da resposta.
     */

    @PostMapping
    public ResponseEntity<UsoMedicamento> agendar(@RequestBody @Validated UsoMedicamento uso) {
        // Chama o serviço para agendar o uso do medicamento (salvar no banco).
        UsoMedicamento criado = service.agendarUso(uso);

        // Retorna resposta HTTP 201 (Created) com o recurso criado e o Location do novo recurso.
        return ResponseEntity
                .created(URI.create("/api/uso-medicamento/" + criado.getId()))
                .body(criado);
    }

    /**
     * Endpoint para listar todos os usos de medicamento numa data específica.
     * - @GetMapping("/por-data"): Mapeia requisições HTTP GET para o caminho /por-data.
     * - @RequestParam: Indica que o parâmetro 'data' será recebido na query string (?data=...).
     * - @DateTimeFormat: Garante que a data será recebida no formato ISO (yyyy-MM-dd).
     *
     * @param data Data para filtrar os usos de medicamento.
     * @return ResponseEntity com status 200 (OK) e a lista de usos encontrados.
     */
    @GetMapping("/por-data")
    public ResponseEntity<List<UsoMedicamento>> listarPorData(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {
        // Chama o serviço para buscar os usos de medicamento na data informada.
        List<UsoMedicamento> lista = service.listarPorData(data);

        // Retorna resposta HTTP 200 (OK) com a lista de usos encontrados.
        return ResponseEntity.ok(lista);
    }
}