package com.agpf.recrutamento.enumType;

public enum LevelType {

    TRAINEE("Estagiário"),
    JR("Júnior"),
    PLENO("Pleno"),
    SENIOR("Senior"),
    TECH_LEAD("Tech Lead");

    private final String description;

    LevelType(String description){ this.description = description; }

    public String getDescription() {
        return this.description;
    }
}
