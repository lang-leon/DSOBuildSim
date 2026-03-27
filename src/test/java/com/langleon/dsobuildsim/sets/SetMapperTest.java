package com.langleon.dsobuildsim.sets;

import tools.jackson.databind.ObjectMapper;
import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.sets.dto.SetDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class SetMapperTest {

    private SetConfig setConfig;

    @BeforeEach
    void setup() throws IOException
    {
        try (var reader = new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/gamedata/sets.json"))))
        {
            ObjectMapper objectMapper = new ObjectMapper();
            setConfig = objectMapper.readValue(reader, SetConfig.class);
        }
    }

    @Test
    void shouldMapSetDefinitionToSetDTO()
    {
        SetDTO setDTO = SetMapper.from(setConfig.spellweaverSets().get(SetType.STELLAR_WALKER));
        Map<Integer, Map<StatType, Double>> stats = Map.of(
                2, Map.of(StatType.ATTACK_SPEED, 0.79),
                4, Map.of(StatType.DAMAGE, 8657.0),
                6, Map.of(StatType.MANA, 68.0)
        );

        Map<Integer, String> description = Map.of(
                4, "For every 100 points of Mana consumed, you will enter a Instinct Awakening state. Increase damage by 10% and increase the Concentration cost of all skills by 5% for 5 seconds, stacking up to 10 times.",
                6, "Your Magic Missile is turned into an Ice piercing bullet and the skill Damage is turned into Ice and increased by 50%"
        );

        Assertions.assertEquals(SetType.STELLAR_WALKER, setDTO.setType());
        Assertions.assertEquals("Stellar Walker", setDTO.name());
        Assertions.assertEquals(140, setDTO.level());
        Assertions.assertEquals(Set.of("STELLAR_WALKER_SHOULDERS", "STELLAR_WALKER_CLOAK", "STELLAR_WALKER_HELMET", "STELLAR_WALKER_GLOVES", "STELLAR_WALKER_TORSO", "STELLAR_WALKER_BOOTS"), setDTO.setItems());
        Assertions.assertEquals(stats, setDTO.baseValuesPerTier());
        Assertions.assertEquals(Map.of(), setDTO.relativeValuesPerTier());
        Assertions.assertEquals(description, setDTO.descriptionPerTier());
    }
}
