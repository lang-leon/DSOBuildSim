package com.langleon.dsobuildsim.dragonstones;

import com.langleon.dsobuildsim.dragonstones.dto.DragonCrestTrinketDTO;
import com.langleon.dsobuildsim.dragonstones.dto.DragonStoneInstanceDTO;
import com.langleon.dsobuildsim.gamedata.GameDataConfig;
import com.langleon.dsobuildsim.gamedata.GameDataLoader;
import com.langleon.dsobuildsim.common.StatType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class DragonStoneFactoryTest {

    private DragonStoneFactory dragonStoneFactory;

    @BeforeEach
    void setup()
    {
        GameDataConfig config = new GameDataLoader().loadGameDataConfig();
        dragonStoneFactory = new DragonStoneFactory(config);
    }

    @Test
    void createHatchlingsPowerstone()
    {
        DragonStone dragonStone = dragonStoneFactory.createDragonStone(DragonStoneType.POWERSTONE, 3);
        Assertions.assertNotNull(dragonStone);
        Assertions.assertEquals(3, dragonStone.tier());
        Assertions.assertTrue(dragonStone.stats().containsKey(StatType.HEALTH_POINTS));
        Assertions.assertEquals(0.025, dragonStone.stats().get(StatType.HEALTH_POINTS));
        Assertions.assertEquals("+ 2.50% Health Points", dragonStone.description());
    }

    @Test
    void createMightyGreedstone()
    {
        DragonStone dragonStone = dragonStoneFactory.createDragonStone(DragonStoneType.GREEDSTONE, 4);
        Assertions.assertNotNull(dragonStone);
        Assertions.assertEquals(4, dragonStone.tier());
        Assertions.assertTrue(dragonStone.stats().containsKey(StatType.ANDERMANT_DROP_BONUS));
        Assertions.assertEquals(0.01, dragonStone.stats().get(StatType.ANDERMANT_DROP_BONUS));
        Assertions.assertEquals("+ 1% drop stack size of Andermant", dragonStone.description());
    }

    @Test
    void createEldersRestlessStone()
    {
        DragonStone dragonStone = dragonStoneFactory.createDragonStone(DragonStoneType.RESTLESS_STONE, 5);
        Assertions.assertNotNull(dragonStone);
        Assertions.assertEquals(5, dragonStone.tier());
        Assertions.assertTrue(dragonStone.stats().containsKey(StatType.DAMAGE));
        Assertions.assertTrue(dragonStone.stats().containsKey(StatType.ATTACK_SPEED));
        Assertions.assertEquals(-0.015, dragonStone.stats().get(StatType.DAMAGE));
        Assertions.assertEquals(0.015, dragonStone.stats().get(StatType.ATTACK_SPEED));
        Assertions.assertEquals("Condensed from a Dragon Elder's blood, this crystal is brimming with a faint aura of restlessness. With the Dragon Crest inserted, attack speed increases by 1.5%, damage percentage decreases by 1.5%\n- 1.50% damage.", dragonStone.description());
    }

    @Test
    void shouldResolveDragonStoneFromDragonStoneDTO()
    {
        DragonStoneInstanceDTO dto = new DragonStoneInstanceDTO(DragonStoneType.POWERSTONE, 4);

        DragonStone dragonStone = dragonStoneFactory.fromDTO(dto);

        Assertions.assertEquals(DragonStoneType.POWERSTONE, dragonStone.dragonStoneType());
        Assertions.assertEquals(4, dragonStone.tier());
        Assertions.assertEquals(Map.of(StatType.HEALTH_POINTS, 0.05), dragonStone.stats());
        Assertions.assertEquals("+ 5.00% Health Points", dragonStone.description());
    }

    @Test
    void shouldResolveDragonStonesFromDragonStoneDTOs()
    {
        DragonStoneInstanceDTO dragonStoneDefinitionDTO1 = new DragonStoneInstanceDTO(DragonStoneType.POWERSTONE,4);
        DragonStoneInstanceDTO dragonStoneDefinitionDTO2 = new DragonStoneInstanceDTO(DragonStoneType.GREEDSTONE, 4);
        List<DragonStoneInstanceDTO> dragonStoneInstanceDTOs = List.of(dragonStoneDefinitionDTO1, dragonStoneDefinitionDTO2);
        List<DragonStone> dragonStones = dragonStoneFactory.fromDTOList(dragonStoneInstanceDTOs);

        Assertions.assertEquals(DragonStoneType.POWERSTONE, dragonStones.getFirst().dragonStoneType());
        Assertions.assertEquals(4, dragonStones.getFirst().tier());
        Assertions.assertEquals(Map.of(StatType.HEALTH_POINTS, 0.05), dragonStones.getFirst().stats());
        Assertions.assertEquals("+ 5.00% Health Points", dragonStones.getFirst().description());
        Assertions.assertEquals(DragonStoneType.GREEDSTONE, dragonStones.get(1).dragonStoneType());
        Assertions.assertEquals(4, dragonStones.get(1).tier());
        Assertions.assertEquals(Map.of(StatType.ANDERMANT_DROP_BONUS, 0.01), dragonStones.get(1).stats());
        Assertions.assertEquals("+ 1% drop stack size of Andermant", dragonStones.get(1).description());
    }

    @Test
    void shouldResolveDragonStonesFromDragonCrestDTO()
    {
        DragonStoneInstanceDTO dragonStoneDefinitionDTO1 = new DragonStoneInstanceDTO(DragonStoneType.POWERSTONE,4);
        DragonStoneInstanceDTO dragonStoneDefinitionDTO2 = new DragonStoneInstanceDTO(DragonStoneType.GREEDSTONE, 4);
        List<DragonStoneInstanceDTO> dragonStoneInstanceDTOs = List.of(dragonStoneDefinitionDTO1, dragonStoneDefinitionDTO2);
        DragonCrestTrinketDTO dragonCrestTrinketDTO = new DragonCrestTrinketDTO(dragonStoneInstanceDTOs);
        DragonCrestTrinket dragonCrest = dragonStoneFactory.fromDTO(dragonCrestTrinketDTO);

        Assertions.assertEquals(DragonStoneType.POWERSTONE, dragonCrest.getDragonStones().getFirst().dragonStoneType());
        Assertions.assertEquals(4, dragonCrest.getDragonStones().getFirst().tier());
        Assertions.assertEquals(Map.of(StatType.HEALTH_POINTS, 0.05), dragonCrest.getDragonStones().getFirst().stats());
        Assertions.assertEquals("+ 5.00% Health Points", dragonCrest.getDragonStones().getFirst().description());
        Assertions.assertEquals(DragonStoneType.GREEDSTONE, dragonCrest.getDragonStones().get(1).dragonStoneType());
        Assertions.assertEquals(4, dragonCrest.getDragonStones().get(1).tier());
        Assertions.assertEquals(Map.of(StatType.ANDERMANT_DROP_BONUS, 0.01), dragonCrest.getDragonStones().get(1).stats());
        Assertions.assertEquals("+ 1% drop stack size of Andermant", dragonCrest.getDragonStones().get(1).description());
    }
}
