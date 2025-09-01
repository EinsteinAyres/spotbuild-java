package com.qu4rx.spotbuild.domain.enums;

/**
 * Enumeração (enum) que representa as possíveis vias de administração de medicamentos.
 *
 * <p>
 * Uma enum em Java é um tipo especial de classe que define um conjunto fixo de constantes.
 * É usada quando você tem um grupo limitado e bem definido de opções, como dias da semana,
 * status de pedidos, ou, neste caso, vias de administração de medicamentos.
 * </p>
 *
 * <p>
 * Vantagens de usar enum:
 * <ul>
 *   <li>Segurança de tipo: só aceita valores válidos, evitando erros de digitação.</li>
 *   <li>Facilidade de manutenção: para adicionar ou remover opções, basta alterar a enum.</li>
 *   <li>Legibilidade: o código fica mais claro e fácil de entender.</li>
 * </ul>
 * </p>
 */
public enum ViaAdministracao {
    /**
     * Administração oral: o medicamento é ingerido pela boca (comprimidos, cápsulas, líquidos, etc).
     * Exemplo: Paracetamol em comprimido.
     */
    ORAL,

    /**
     * Injetável intramuscular: o medicamento é aplicado por injeção diretamente no músculo.
     * Exemplo: Vacinas aplicadas no braço ou nádega.
     */
    INJETAVEL_INTRAMUSCULAR,

    /**
     * Injetável subcutânea: o medicamento é aplicado por injeção sob a pele, no tecido subcutâneo.
     * Exemplo: Insulina para diabéticos.
     */
    INJETAVEL_SUBCUTANEA,

    /**
     * Transdérmica: o medicamento é administrado através da pele, geralmente por adesivos ou cremes.
     * Exemplo: Adesivo de nicotina.
     */
    TRANSDERMICA,

    /**
     * Nasal: o medicamento é administrado pelas vias nasais (nariz), como sprays ou gotas.
     * Exemplo: Descongestionantes nasais.
     */
    NASAL,

    /**
     * Outra: qualquer outra via de administração que não se enquadre nas opções acima.
     * Exemplo: Via oftálmica (olhos), via retal, etc.
     */
    OUTRA
}