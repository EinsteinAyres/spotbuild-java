package com.qu4rx.spotbuild.infrastructure.persistence;

// Importa a entidade UsoMedicamento, que representa um registro de uso de medicamento no sistema.
import com.qu4rx.spotbuild.domain.entity.UsoMedicamento;

// Importa a interface JpaRepository, que fornece métodos prontos para operações CRUD (Create, Read, Update, Delete)
// e outras operações de banco de dados, usando o padrão Repository do Spring Data JPA.
import org.springframework.data.jpa.repository.JpaRepository;

// Importa a anotação @Repository, que marca a interface como um componente de persistência.
// O Spring detecta automaticamente classes/interfaces anotadas com @Repository e as gerencia como beans.
import org.springframework.stereotype.Repository;

// Importa tipos utilitários para manipulação de datas e listas.
import java.time.LocalDateTime;
import java.util.List;

/**
 * Interface de repositório JPA para a entidade UsoMedicamento.
 *
 * <p>
 * O Spring Data JPA permite que você defina interfaces de repositório que herdam de JpaRepository.
 * Com isso, você ganha automaticamente métodos prontos para salvar, buscar, atualizar e deletar entidades,
 * sem precisar escrever implementações manuais de acesso ao banco de dados.
 * </p>
 *
 * <p>
 * Além dos métodos herdados, você pode definir métodos customizados apenas escrevendo o nome do método
 * seguindo convenções do Spring Data JPA. O framework interpreta o nome e gera a consulta SQL correspondente.
 * </p>
 */
@Repository // Indica que esta interface é um repositório de dados gerenciado pelo Spring.
public interface UsoMedicamentoJpaRepository
        extends JpaRepository<UsoMedicamento, Long> {
    // Herda todos os métodos do JpaRepository, como:
    // - save(UsoMedicamento entity): salva ou atualiza um registro.
    // - findById(Long id): busca um registro pelo ID.
    // - findAll(): retorna todos os registros.
    // - deleteById(Long id): remove um registro pelo ID.
    // E muitos outros métodos úteis.

    /**
     * Busca todos os registros de UsoMedicamento cuja data/hora programada esteja entre dois instantes.
     *
     * <p>
     * O nome do método segue o padrão do Spring Data JPA:
     * - "findBy" indica que é uma busca.
     * - "DataHoraProgramada" é o nome do atributo na entidade UsoMedicamento.
     * - "Between" indica que queremos registros entre dois valores (inclusive).
     * </p>
     *
     * <p>
     * O Spring Data JPA irá gerar automaticamente a consulta SQL equivalente a:
     * <pre>
     * SELECT * FROM uso_medicamento
     * WHERE data_hora_programada >= :inicio AND data_hora_programada <= :fim
     * </pre>
     * </p>
     *
     * @param inicio Data/hora inicial do intervalo (inclusive).
     * @param fim    Data/hora final do intervalo (inclusive).
     * @return Lista de UsoMedicamento encontrados no intervalo especificado.
     */
    List<UsoMedicamento> findByDataHoraProgramadaBetween(LocalDateTime inicio, LocalDateTime fim);
}