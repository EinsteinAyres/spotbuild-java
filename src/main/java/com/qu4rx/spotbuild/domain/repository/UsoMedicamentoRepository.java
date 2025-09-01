package com.qu4rx.spotbuild.domain.repository;

// Importa a classe UsoMedicamento, que representa a entidade de uso de medicamentos.
import com.qu4rx.spotbuild.domain.entity.UsoMedicamento;

// Importa o tipo LocalDate, usado para representar datas sem horário.
import java.time.LocalDate;

// Importa a interface List, que representa uma lista de elementos.
import java.util.List;

/**
 * Interface que define o contrato para operações de persistência e consulta
 * relacionadas à entidade UsoMedicamento.
 *
 * <p>
 * O padrão Repository é utilizado para abstrair o acesso a dados, permitindo
 * que a lógica de negócio não dependa diretamente de detalhes de implementação
 * de banco de dados ou frameworks de persistência.
 * </p>
 *
 * <p>
 * Uma interface, em Java, define um conjunto de métodos que devem ser
 * implementados por uma classe concreta. Aqui, não há implementação, apenas a
 * assinatura dos métodos.
 * </p>
 */
public interface UsoMedicamentoRepository {

    /**
     * Salva um objeto UsoMedicamento no repositório (banco de dados, memória, etc).
     * Se o objeto já existir (por exemplo, tiver um ID), pode atualizar; se não,
     * pode inserir um novo registro.
     *
     * @param uso O objeto UsoMedicamento a ser salvo.
     * @return O objeto UsoMedicamento salvo, possivelmente com o ID preenchido.
     */
    UsoMedicamento salvar(UsoMedicamento uso);

    /**
     * Busca todos os registros de UsoMedicamento associados a um determinado usuário.
     *
     * @param usuarioId O identificador único do usuário.
     * @return Uma lista de objetos UsoMedicamento pertencentes ao usuário informado.
     */
    List<UsoMedicamento> buscarPorUsuario(Long usuarioId);

    /**
     * Busca todos os registros de UsoMedicamento programados para uma data específica.
     *
     * @param data A data para a qual se deseja buscar os usos de medicamentos.
     * @return Uma lista de objetos UsoMedicamento programados para a data informada.
     */
    List<UsoMedicamento> buscarPorData(LocalDate data);
}