package com.qu4rx.spotbuild.domain.entity;

// Importa a enum ViaAdministracao do domínio
import com.qu4rx.spotbuild.domain.enums.ViaAdministracao;

// Importa anotações e tipos do JPA para mapeamento da entidade
import jakarta.persistence.*;

// Importa a anotação @Data do Lombok para gerar automaticamente getters, setters, equals, hashCode e toString
import lombok.Data;

// Importa o tipo LocalDateTime para datas e horas
import java.time.LocalDateTime;

// Lombok: Gera automaticamente getters, setters, equals, hashCode e toString
@Data
// JPA: Indica que esta classe é uma entidade persistente (tabela no banco de dados)
@Entity
public class UsoMedicamento {

    // Identificador único da entidade, gerado automaticamente pelo banco (auto-incremento)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nome do medicamento utilizado
    private String medicamento;

    // Dose do medicamento administrado
    private String dose;

    // Enum que representa a via de administração do medicamento (oral, intravenosa, etc.)
    @Enumerated(EnumType.STRING)
    private ViaAdministracao via;

    // Data e hora programadas para administração do medicamento
    private LocalDateTime dataHoraProgramada;

    // Data e hora em que o medicamento foi realmente administrado
    private LocalDateTime dataHoraExecutada;

    // Campo para observações adicionais sobre o uso do medicamento
    private String observacoes;

       public Long getId() {
        return id;
       }

    // Os métodos getters, setters, equals e hashCode são gerados automaticamente pelo Lombok (@Data)
}