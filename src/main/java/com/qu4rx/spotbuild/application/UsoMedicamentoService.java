package com.qu4rx.spotbuild.application;

// Importa a entidade de domínio que representa o uso de medicamento.
import com.qu4rx.spotbuild.domain.entity.UsoMedicamento;

// Importa o repositório JPA responsável pelo acesso ao banco de dados.
import com.qu4rx.spotbuild.infrastructure.persistence.UsoMedicamentoJpaRepository;

// Importa a anotação do Spring que marca a classe como um serviço.
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 * Serviço de aplicação responsável pela lógica de negócio relacionada ao uso de medicamentos.
 * - @Service: indica que esta classe é um componente de serviço do Spring,
 *   permitindo que seja injetada em outros componentes.
 */
@Service
public class UsoMedicamentoService {

    // Dependência do repositório JPA para operações de persistência.
    private final UsoMedicamentoJpaRepository repo;

    /**
     * Construtor que recebe o repositório como dependência.
     * O Spring injeta automaticamente a implementação do repositório.
     *
     * @param repo Instância do repositório JPA para UsoMedicamento.
     */
    public UsoMedicamentoService(UsoMedicamentoJpaRepository repo) {
        this.repo = repo;
    }

    /**
     * Agenda (salva) um novo uso de medicamento no banco de dados.
     *
     * @param uso Objeto UsoMedicamento a ser salvo.
     * @return O objeto salvo, incluindo o ‘ID’ gerado pelo banco.
     */
    public UsoMedicamento agendarUso(UsoMedicamento uso) {
        // Salva o uso de medicamento no banco e retorna o objeto persistido.
        return repo.save(uso);
    }

    /**
     * Lista todos os usos de medicamento agendados para uma data específica.
     *
     * @param data Data para filtrar os usos de medicamento.
     * @return Lista de usos de medicamento encontrados na data informada.
     */
    public List<UsoMedicamento> listarPorData(LocalDate data) {
        // Define o início do dia (00:00:00) para a data informada.
        LocalDateTime inicio = data.atStartOfDay();
        // Define o fim do dia (23:59:59.999999999) para a data informada.
        LocalDateTime fim = data.atTime(LocalTime.MAX);
        // Busca no banco todos os usos de medicamento agendados entre o início e o fim do dia.
        return repo.findByDataHoraProgramadaBetween(inicio, fim);
    }
}