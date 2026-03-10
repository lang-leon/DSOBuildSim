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

        Gem gem = gemResolver.resolve(gemDTO);

        Assertions.assertEquals(GemType.RUBY, gem.getGemType());
        Assertions.assertEquals(16, gem.getTier());
        Assertions.assertEquals(Map.of(StatType.DAMAGE, 600.0), gem.getStats());
    }

    @Test
    void shouldResolveOpalFromOpalDTO()
    {
        OpalDTO opalDTO = new OpalDTO(GemType.RUBY, GemType.ONYX, GemType.AMETHYST, 16);

        Opal opal = gemResolver.resolve(opalDTO);

        Assertions.assertEquals(GemType.OPAL, opal.getGemType());
        Assertions.assertEquals(16, opal.getTier());
        Assertions.assertEquals(Map.of(StatType.DAMAGE, 450.0, StatType.CRIT_VALUE, 1687.5, StatType.HEALTH_POINTS, 3675.0), opal.getStats());
    }
}
