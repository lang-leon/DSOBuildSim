package com.langleon.dsobuildsim.buffs.enums;

public enum TonicType implements BuffType{
    VITALITY("Tonic of Vitality"),
    EFFICACY("Tonic of Efficacy"),
    VIGOR("Tonic of Vigor"),
    FORTITUDE("Tonic of Fortitude"),
    DETERMINATION("Tonic of Determination"),
    CELERITY("Tonic of Celerity"),
    PRECISION("Tonic of Precision"),
    RESILIENCE_FIRE("Tonic of Resilience (Fire)"),
    RESILIENCE_POISON("Tonic of Resilience (Poison)"),
    RESILIENCE_ICE("Tonic of Resilience (Ice)"),
    RESILIENCE_LIGHTNING("Tonic of Resilience (Lightning)"),
    RESILIENCE_ANDERMAGIC("Tonic of Resilience (Andermagic)"),
    ;

    private final String name;

    TonicType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
