package com.agpf.recrutamento.enumType;

public enum HierarchyType {

    ESTAGIARIO("Estagiário"),
    JUNIOR("Junior"),
    PLENO("Pleno"),
    SENIOR("Sênior"),
    TECH_LEAD("Tech Lead"),
    COORDENADOR("Coordenador");

    private String description;

    HierarchyType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
