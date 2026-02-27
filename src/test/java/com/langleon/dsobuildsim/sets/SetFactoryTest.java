package com.langleon.dsobuildsim.sets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.langleon.dsobuildsim.enums.CharacterClass;
import com.langleon.dsobuildsim.enums.StatType;
import com.langleon.dsobuildsim.enums.items.SetItemType;
import com.langleon.dsobuildsim.enums.items.SetType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

class SetFactoryTest {

    private SetFactory setFactory;

    @BeforeEach
    void setup() throws IOException {
        try (var reader = new InputStreamReader(getClass().getResourceAsStream("/data/sets.json"))) {
            ObjectMapper objectMapper = new ObjectMapper();
            SetConfig setConfig = objectMapper.readValue(reader, SetConfig.class);
            setFactory = new SetFactory(setConfig);
        }
    }

    @Test
    void shouldCreateSetInstanceWithDefaultValues()
    {
        SetInstance setInstance = setFactory.createSet(SetType.MIGHT_OF_THE_WOLF_SLAYER, CharacterClass.SPELLWEAVER);
        Assertions.assertEquals(145, setInstance.getLevel());
        Assertions.assertEquals("Might of the Wolf Slayer", setInstance.getName());
        Assertions.assertEquals(List.of(), setInstance.getEquippedSetItems());
        Assertions.assertEquals(SetType.MIGHT_OF_THE_WOLF_SLAYER, setInstance.getSetType());
        Assertions.assertEquals(0, setInstance.getCurrentSetBonusLevel());
        Assertions.assertEquals(Map.of(), setInstance.getActiveBaseValues());
        Assertions.assertEquals(Map.of(), setInstance.getActiveRelativeValues());
    }

    @Test
    void shouldUpdateSetInstanceWhenItemsAreEquipped()
    {
        SetInstance setInstance = setFactory.createSet(SetType.JOY_OF_SPRING, CharacterClass.SPELLWEAVER);
        setInstance.addSetItem(SetItemType.SPRING_RING1.toString());
        Assertions.assertEquals(List.of("SPRING_RING1"), setInstance.getEquippedSetItems());
        Assertions.assertEquals(1, setInstance.getCurrentSetBonusLevel());
        Assertions.assertEquals(Map.of(StatType.CRIT_VALUE, 2835.0), setInstance.getActiveBaseValues());
        Assertions.assertEquals(Map.of(), setInstance.getActiveRelativeValues());
    }

    @Test
    void shouldAddAndRemoveSetItemCorrectly()
    {
        SetInstance setInstance = setFactory.createSet(SetType.JOY_OF_SPRING, CharacterClass.SPELLWEAVER);
        setInstance.addSetItem(SetItemType.SPRING_RING1.toString());
        Assertions.assertEquals(List.of("SPRING_RING1"), setInstance.getEquippedSetItems());
        Assertions.assertEquals(1, setInstance.getCurrentSetBonusLevel());
        Assertions.assertEquals(Map.of(StatType.CRIT_VALUE, 2835.0), setInstance.getActiveBaseValues());
        Assertions.assertEquals(Map.of(), setInstance.getActiveRelativeValues());
        setInstance.addSetItem(SetItemType.SPRING_RING2.toString());
        Assertions.assertEquals(List.of("SPRING_RING1", "SPRING_RING2"), setInstance.getEquippedSetItems());
        Assertions.assertEquals(2, setInstance.getCurrentSetBonusLevel());
        Assertions.assertEquals(Map.of(StatType.CRIT_VALUE, 2835.0, StatType.DAMAGE, 6572.0), setInstance.getActiveBaseValues());
        Assertions.assertEquals(Map.of(), setInstance.getActiveRelativeValues());
        setInstance.removeSetItem(SetItemType.SPRING_RING1.toString());
        Assertions.assertEquals(List.of("SPRING_RING2"), setInstance.getEquippedSetItems());
        Assertions.assertEquals(1, setInstance.getCurrentSetBonusLevel());
        Assertions.assertEquals(Map.of(StatType.CRIT_VALUE, 2835.0), setInstance.getActiveBaseValues());
        Assertions.assertEquals(Map.of(), setInstance.getActiveRelativeValues());
    }

    @Test
    void shouldNotIncreaseSetBonusWhenAddingDuplicateItem()
    {
        SetInstance setInstance = setFactory.createSet(SetType.JOY_OF_SPRING, CharacterClass.SPELLWEAVER);
        setInstance.addSetItem(SetItemType.SPRING_RING1.toString());
        Assertions.assertEquals(List.of("SPRING_RING1"), setInstance.getEquippedSetItems());
        Assertions.assertEquals(1, setInstance.getCurrentSetBonusLevel());
        Assertions.assertEquals(Map.of(StatType.CRIT_VALUE, 2835.0), setInstance.getActiveBaseValues());
        Assertions.assertEquals(Map.of(), setInstance.getActiveRelativeValues());
        setInstance.addSetItem(SetItemType.SPRING_RING1.toString());
        Assertions.assertEquals(List.of("SPRING_RING1", "SPRING_RING1"), setInstance.getEquippedSetItems());
        Assertions.assertEquals(1, setInstance.getCurrentSetBonusLevel());
        Assertions.assertEquals(Map.of(StatType.CRIT_VALUE, 2835.0), setInstance.getActiveBaseValues());
        Assertions.assertEquals(Map.of(), setInstance.getActiveRelativeValues());
        setInstance.removeSetItem(SetItemType.SPRING_RING1.toString());
        Assertions.assertEquals(List.of("SPRING_RING1"), setInstance.getEquippedSetItems());
        Assertions.assertEquals(1, setInstance.getCurrentSetBonusLevel());
        Assertions.assertEquals(Map.of(StatType.CRIT_VALUE, 2835.0), setInstance.getActiveBaseValues());
        Assertions.assertEquals(Map.of(), setInstance.getActiveRelativeValues());
    }

    @Test
    void shouldThrowExceptionWhenAddingInvalidSetItem()
    {
        SetInstance setInstance = setFactory.createSet(SetType.JOY_OF_SPRING, CharacterClass.SPELLWEAVER);
        Assertions.assertThrows(IllegalArgumentException.class, () -> setInstance.addSetItem(SetItemType.ALLAINCE_ONE_HAND.toString()));
    }
}
