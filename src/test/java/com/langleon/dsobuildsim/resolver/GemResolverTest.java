package com.langleon.dsobuildsim.resolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.langleon.dsobuildsim.common.StatType;
import com.langleon.dsobuildsim.dto.GemDTO;
import com.langleon.dsobuildsim.dto.OpalDTO;
import com.langleon.dsobuildsim.gems.GemFactory;
import com.langleon.dsobuildsim.gems.Gem;
import com.langleon.dsobuildsim.gems.GemConfig;
import com.langleon.dsobuildsim.gems.Opal;
import com.langleon.dsobuildsim.gems.enums.GemLimitGroup;
import com.langleon.dsobuildsim.gems.enums.GemType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class GemResolverTest {
    
    private GemResolver gemResolver;

    @BeforeEach
    void setup() throws IOException
    {
        try (var reader = new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/data/gems.json"))))
        {
            ObjectMapper objectMapper = new ObjectMapper();
            GemConfig gemConfig = objectMapper.readValue(reader, GemConfig.class);
            GemFactory gemFactory = new GemFactory(gemConfig);
            gemResolver = new GemResolver(gemFactory);
        }
    }

    @Test
    void shouldResolveGemFromGemDTO()
    {
        GemDTO gemDTO = new GemDTO(GemType.RUBY, GemLimitGroup.RUBY, 50, 16, StatType.DAMAGE, Map.of(16, 600.0));

        Gem gem = gemResolver.resolveGem(gemDTO);

        Assertions.assertEquals(GemType.RUBY, gem.getGemType());
        Assertions.assertEquals(16, gem.getTier());
        Assertions.assertEquals(Map.of(StatType.DAMAGE, 600.0), gem.getStats());
    }

    @Test
    void shouldResolveGemsFromGemDTOs()
    {
        GemDTO gemDTO1 = new GemDTO(GemType.RUBY, GemLimitGroup.RUBY, 50, 16, StatType.DAMAGE, Map.of(16, 600.0));
        GemDTO gemDTO2 = new GemDTO(GemType.AMETHYST, GemLimitGroup.AMETHYST, 50, 16, StatType.DAMAGE, Map.of(16, 4900.0));
        List<GemDTO> gemDTOs = List.of(gemDTO1, gemDTO2);
        List<Gem> gems = gemResolver.resolveGems(gemDTOs);

        Assertions.assertEquals(GemType.RUBY, gems.getFirst().getGemType());
        Assertions.assertEquals(16, gems.getFirst().getTier());
        Assertions.assertEquals(Map.of(StatType.DAMAGE, 600.0), gems.getFirst().getStats());
        Assertions.assertEquals(GemType.AMETHYST, gems.get(1).getGemType());
        Assertions.assertEquals(16, gems.get(1).getTier());
        Assertions.assertEquals(Map.of(StatType.HEALTH_POINTS, 4900.0), gems.get(1).getStats());
    }

    @Test
    void shouldResolveOpalFromOpalDTO()
    {
        OpalDTO opalDTO = new OpalDTO(GemType.RUBY, GemType.ONYX, GemType.AMETHYST, 16);

        Opal opal = gemResolver.resolveOpal(opalDTO);

        Assertions.assertEquals(GemType.OPAL, opal.getGemType());
        Assertions.assertEquals(16, opal.getTier());
        Assertions.assertEquals(Map.of(StatType.DAMAGE, 450.0, StatType.CRIT_VALUE, 1687.5, StatType.HEALTH_POINTS, 3675.0), opal.getStats());
    }

    @Test
    void shouldResolveOpalsFromOpalDTOs()
    {
        OpalDTO opalDTO1 = new OpalDTO(GemType.RUBY, GemType.ONYX, GemType.AMETHYST, 16);
        OpalDTO opalDTO2 = new OpalDTO(GemType.RUBY, GemType.ONYX, GemType.ZIRCON, 16);
        List<OpalDTO> opalDTOs = List.of(opalDTO1, opalDTO2);
        List<Opal> opals = gemResolver.resolveOpals(opalDTOs);

        Assertions.assertEquals(GemType.OPAL, opals.getFirst().getGemType());
        Assertions.assertEquals(16, opals.getFirst().getTier());
        Assertions.assertEquals(Map.of(StatType.DAMAGE, 450.0, StatType.CRIT_VALUE, 1687.5, StatType.HEALTH_POINTS, 3675.0), opals.getFirst().getStats());
        Assertions.assertEquals(GemType.OPAL, opals.get(1).getGemType());
        Assertions.assertEquals(16, opals.get(1).getTier());
        Assertions.assertEquals(Map.of(StatType.DAMAGE, 450.0, StatType.CRIT_VALUE, 1687.5, StatType.ATTACK_SPEED, 0.012), opals.get(1).getStats());
    }
}
