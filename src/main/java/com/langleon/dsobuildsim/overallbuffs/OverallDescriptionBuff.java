package com.langleon.dsobuildsim.overallbuffs;

public class OverallDescriptionBuff extends OverallBuff{
    private final String description;

    public OverallDescriptionBuff(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
