package com.agpf.recrutamento.EnumType;

public enum StatusType {

    ONGOING("Em andamento"),
    CLOSED("Fechada");

    private final String description;

    StatusType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
