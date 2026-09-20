package com.langleon.dsobuildsim.jewels;

import com.langleon.dsobuildsim.exceptions.InvalidTierException;
import com.langleon.dsobuildsim.gamedata.GameDataConfig;
import com.langleon.dsobuildsim.gamedata.GameDataLoader;
import com.langleon.dsobuildsim.jewels.dto.JewelInstanceDTO;
import com.langleon.dsobuildsim.character.CharacterClass;
import com.langleon.dsobuildsim.common.StatType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class JewelFactoryTest {
    private JewelFactory jewelFactory;

    @BeforeEach
    void setup()
    {
        GameDataConfig config = new GameDataLoader().loadGameDataConfig();
        jewelFactory = new JewelFactory(config);
    }

    @Test
    void createVigorTier5()
    {
        Jewel jewel = jewelFactory.createJewel(JewelType.VIGOR, CharacterClass.SPELLWEAVER, 5);
        Assertions.assertNotNull(jewel);
        Assertions.assertEquals(5, jewel.getTier());
        Assertions.assertEquals(JewelType.VIGOR, jewel.getJewelType());
        Assertions.assertTrue(jewel.getStats().containsKey(StatType.DAMAGE));
        Assertions.assertEquals(1, jewel.getStats().size());
        Assertions.assertEquals(0.1, jewel.getStats().get(StatType.DAMAGE));
    }

    @Test
    void createGemFortune4()
    {
        Jewel jewel = jewelFactory.createJewel(JewelType.GEM_FORTUNE, CharacterClass.SPELLWEAVER, 4);
        Assertions.assertNotNull(jewel);
        Assertions.assertEquals(4, jewel.getTier());
        Assertions.assertEquals(JewelType.GEM_FORTUNE, jewel.getJewelType());
        Assertions.assertTrue(jewel.getStats().isEmpty());
        Assertions.assertEquals("Bosses drop 4 additional gems.", jewel.getDescription());
    }

    @Test
    void throwsOnInvalidTier()
    {
        Assertions.assertThrows(InvalidTierException.class, () -> jewelFactory.createJewel(JewelType.VIGOR, CharacterClass.SPELLWEAVER, -1));
        Assertions.assertThrows(InvalidTierException.class, () -> jewelFactory.createJewel(JewelType.BLACK_KNIGHT_ORDER, CharacterClass.SPELLWEAVER, 5));
    }

    @Test
    void shouldResolveJewelFromJewelDTO()
    {
        JewelInstanceDTO jewelDTO = new JewelInstanceDTO(JewelType.VIGOR, 4);

        Jewel jewel = jewelFactory.fromDTO(jewelDTO, CharacterClass.SPELLWEAVER);

        Assertions.assertEquals(JewelType.VIGOR, jewel.getJewelType());
        Assertions.assertEquals(4, jewel.getTier());
        Assertions.assertEquals(Map.of(StatType.DAMAGE, 0.08), jewel.getStats());
        Assertions.assertEquals("+ 8.00% damage", jewel.getDescription());
    }

    @Test
    void shouldResolveJewelsFromJewelDTOs()
    {
        JewelInstanceDTO jewelDTO1 = new JewelInstanceDTO(JewelType.VIGOR, 4);
        JewelInstanceDTO jewelDTO2 = new JewelInstanceDTO(JewelType.VITALITY, 3);

        List<Jewel> jewels = jewelFactory.fromDTOList(List.of(jewelDTO1, jewelDTO2), CharacterClass.SPELLWEAVER);

        Assertions.assertEquals(JewelType.VIGOR, jewels.getFirst().getJewelType());
        Assertions.assertEquals(4, jewels.getFirst().getTier());
        Assertions.assertEquals(Map.of(StatType.DAMAGE, 0.08), jewels.getFirst().getStats());
        Assertions.assertEquals("+ 8.00% damage", jewels.getFirst().getDescription());
        Assertions.assertEquals(JewelType.VITALITY, jewels.get(1).getJewelType());
        Assertions.assertEquals(3, jewels.get(1).getTier());
        Assertions.assertEquals(Map.of(StatType.HEALTH_POINTS, 0.06), jewels.get(1).getStats());
        Assertions.assertEquals("+ 6.00% Health points", jewels.get(1).getDescription());
    }
}
