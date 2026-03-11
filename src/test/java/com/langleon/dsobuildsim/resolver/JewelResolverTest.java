package com.langleon.dsobuildsim.resolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.langleon.dsobuildsim.character.CharacterClass;
import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.dto.JewelDTO;
import com.langleon.dsobuildsim.jewels.Jewel;
import com.langleon.dsobuildsim.jewels.JewelConfig;
import com.langleon.dsobuildsim.jewels.JewelFactory;
import com.langleon.dsobuildsim.jewels.JewelType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class JewelResolverTest {

    private JewelResolver jewelResolver;

    @BeforeEach
    void setup() throws IOException
    {
        try (var reader = new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/data/jewels.json"))))
        {
            ObjectMapper objectMapper = new ObjectMapper();
            JewelConfig jewelConfig = objectMapper.readValue(reader, JewelConfig.class);
            JewelFactory jewelFactory = new JewelFactory(jewelConfig);
            jewelResolver = new JewelResolver(jewelFactory);
        }
    }

    @Test
    void shouldResolveJewelFromJewelDTO()
    {
        JewelDTO jewelDTO = new JewelDTO(JewelType.VIGOR, "Jewel of Vigor", 4, CharacterClass.SPELLWEAVER, Map.of(4, Map.of(StatType.DAMAGE, 0.08)), Map.of(4, "+ 8.00% damage"));

        Jewel jewel = jewelResolver.resolveJewel(jewelDTO);

        Assertions.assertEquals(JewelType.VIGOR, jewel.getJewelType());
        Assertions.assertEquals(4, jewel.getTier());
        Assertions.assertEquals(Map.of(StatType.DAMAGE, 0.08), jewel.getStats());
        Assertions.assertEquals("+ 8.00% damage", jewel.getDescription());
    }

    @Test
    void shouldResolveJewelsFromJewelDTOs()
    {
        JewelDTO jewelDTO1 = new JewelDTO(JewelType.VIGOR, "Jewel of Vigor", 4, CharacterClass.SPELLWEAVER, Map.of(4, Map.of(StatType.DAMAGE, 0.08)), Map.of(4, "+ 8.00% damage"));
        JewelDTO jewelDTO2 = new JewelDTO(JewelType.VITALITY, "Jewel of Vitality", 3, CharacterClass.SPELLWEAVER, Map.of(3, Map.of(StatType.DAMAGE, 0.06)), Map.of(3, "+ 6.00% health points"));

        List<Jewel> jewels = jewelResolver.resolveJewels(List.of(jewelDTO1, jewelDTO2));

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
