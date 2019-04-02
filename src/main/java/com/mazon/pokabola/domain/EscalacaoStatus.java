package com.mazon.pokabola.domain;

public enum EscalacaoStatus {
    PENDENTE ("P", "Pendente"),
    CONFIRMADO ("C", "Confirmado"),
    NAO_JOGA ("N", "Não joga");

    private final String value;
    private final String description;

    EscalacaoStatus(final String value, final String description) {
        this.value = value;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String toValue() {
        return value;
    }

}
