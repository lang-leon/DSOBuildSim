package com.langleon.dsobuildsim.enums.items;

public enum SetType {
    FORGOTTEN_GLORY("Forgotten Glory"),
    ANCESTRAL_GLORY("Ancestral Glory"),

    ;

    private final String name;

    SetType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
