package com.agpf.recrutamento.EnumType;

public enum JobType {

    HYBRID("Hibrído"),
    REMOTE("Remoto"),
    IN_PERSON("Presencial");

    private final String description;

    JobType(String description) { this.description = description; }

    public String getDescription() {
        return this.description;
    }
}
