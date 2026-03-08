package com.langleon.dsobuildsim.buffs.enums;

public enum PhysicType {
    //Simple Physics
    VITALITY_SIMPLE("Simple Physic of Vitality"),
    EFFICACY_SIMPLE("Simple Physic of Efficacy"),
    VIGOR_SIMPLE("Simple Physic of Vigor"),
    FORTITUDE_SIMPLE("Simple Physic of Fortitude"),
    DETERMINATION_SIMPLE("Simple Physic of Determination"),
    CELERITY_SIMPLE("Simple Physic of Celerity"),
    ALACRITY_SIMPLE("Simple Physic of Alacrity"),
    PRECISION_SIMPLE("Simple Physic of Precision"),
    RESILIENCE_FIRE_SIMPLE("Simple Physic of Resilience (Fire)"),
    RESILIENCE_POISON_SIMPLE("Simple Physic of Resilience (Poison)"),
    RESILIENCE_ICE_SIMPLE("Simple Physic of Resilience (Ice)"),
    RESILIENCE_LIGHTNING_SIMPLE("Simple Physic of Resilience (Lightning)"),
    RESILIENCE_ANDERMAGIC_SIMPLE("Simple Physic of Resilience (Andermagic)"),

    //Advanced Physics
    VITALITY_ADVANCED("Advanced Physic of Vitality"),
    EFFICACY_ADVANCED("Advanced Physic of Efficacy"),
    VIGOR_ADVANCED("Advanced Physic of Vigor"),
    FORTITUDE_ADVANCED("Advanced Physic of Fortitude"),
    DETERMINATION_ADVANCED("Advanced Physic of Determination"),
    CELERITY_ADVANCED("Advanced Physic of Celerity"),
    ALACRITY_ADVANCED("Advanced Physic of Alacrity"),
    PRECISION_ADVANCED("Advanced Physic of Precision"),
    RESILIENCE_FIRE_ADVANCED("Advanced Physic of Resilience (Fire)"),
    RESILIENCE_POISON_ADVANCED("Advanced Physic of Resilience (Poison)"),
    RESILIENCE_ICE_ADVANCED("Advanced Physic of Resilience (Ice)"),
    RESILIENCE_LIGHTNING_ADVANCED("Advanced Physic of Resilience (Lightning)"),
    RESILIENCE_ANDERMAGIC_ADVANCED("Advanced Physic of Resilience (Andermagic)");
    ;

    private final String name;

    PhysicType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
