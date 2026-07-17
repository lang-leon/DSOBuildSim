package com.langleon.dsobuildsim.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GameDataControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldReturnGameDataConfig() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/game-data"))
                .andExpect(status().isOk())
                .andReturn();

        String actualJson = result.getResponse().getContentAsString();

        Assertions.assertThat(actualJson)
                .contains("characterClassStats")
                .contains("items")
                .contains("sets")
                .contains("jewels")
                .contains("enchantments")
                .contains("gems")
                .contains("runes")
                .contains("dragonStones")
                .contains("pets")
                .contains("essences")
                .contains("tonics")
                .contains("physics")
                .contains("levelMultiplierTable")
                .contains("wisdomSkillTree");
    }

}
