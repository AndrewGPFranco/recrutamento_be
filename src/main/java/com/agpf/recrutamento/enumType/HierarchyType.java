package com.agpf.recrutamento.enumType;

public enum HierarchyType {

    ESTAGIARIO("Estagiário"),
    JUNIOR("Junior"),
    PLENO("Pleno"),
    SENIOR("Sênior"),
    TECH_LEAD("Tech Lead"),
    COORDENADOR("Coordenador"),
    SEM_CARGO("Sem cargo");

    private String description;

    HierarchyType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static HierarchyType fromDescription(String description) {
        for (HierarchyType level : HierarchyType.values()) {
            if (level.getDescription().equalsIgnoreCase(description)) {
                return level;
            }
        }

        return SEM_CARGO;
    }
}
