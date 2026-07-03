package com.langleon.dsobuildsim.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.langleon.dsobuildsim.api.ErrorResponse;
import com.langleon.dsobuildsim.character.dto.CharacterDTO;
import com.langleon.dsobuildsim.character.dto.CharacterStatsDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.StandardCharsets;

@SpringBootTest
@AutoConfigureMockMvc
public class StatsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldReturnStatsSuccessfully() throws Exception {
        CharacterDTO characterDTO = loadJson("validCharacterDTO.json", CharacterDTO.class);
        CharacterStatsDTO expected = loadJson("statsDTO.json", CharacterStatsDTO.class);

        MvcResult result = mockMvc.perform(post("/api/stats/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(characterDTO)))
                        .andExpect(status().isOk())
                        .andReturn();

        String responseJson = result.getResponse().getContentAsString();

        CharacterStatsDTO actual = objectMapper.readValue(responseJson, CharacterStatsDTO.class);

        Assertions.assertEquals(expected.stats().keySet(), actual.stats().keySet());
        expected.stats().forEach((k, v) -> {
            Assertions.assertTrue(actual.stats().containsKey(k));
            Assertions.assertEquals(v, actual.stats().get(k), 0.000001);
        });
    }

    @Test
    void shouldReturnBadRequest_whenInvalidTier() throws Exception {
        CharacterDTO characterDTO = loadJson("invalidTierCharacterDTO.json", CharacterDTO.class);

        MvcResult result = mockMvc.perform(post("/api/stats/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(characterDTO)))
                .andExpect(status().isBadRequest())
                .andReturn();

        String responseJson = result.getResponse().getContentAsString();

        ErrorResponse actual = objectMapper.readValue(responseJson, ErrorResponse.class);

        Assertions.assertEquals(400, actual.getStatus());
        Assertions.assertEquals("/api/stats/calculate", actual.getPath());
        Assertions.assertEquals("Invalid request", actual.getError());
        Assertions.assertEquals("INVALID_TIER", actual.getErrorCode());
        Assertions.assertEquals("Invalid rune tier 6 for rune type VIGOR", actual.getMessage());
    }

    @Test
    void shouldReturnBadRequest_whenInvalidItems() throws Exception {
        CharacterDTO characterDTO = loadJson("invalidItemsCharacterDTO.json", CharacterDTO.class);

        MvcResult result = mockMvc.perform(post("/api/stats/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(characterDTO)))
                .andExpect(status().isBadRequest())
                .andReturn();

        String responseJson = result.getResponse().getContentAsString();

        ErrorResponse actual = objectMapper.readValue(responseJson, ErrorResponse.class);

        Assertions.assertEquals(400, actual.getStatus());
        Assertions.assertEquals("/api/stats/calculate", actual.getPath());
        Assertions.assertEquals("Invalid request", actual.getError());
        Assertions.assertEquals("INVALID_ITEMS_EQUIPPED", actual.getErrorCode());
        Assertions.assertEquals("Equipped one hand and two hand items", actual.getMessage());
    }

    @Test
    void shouldReturnBadRequest_whenExceededLimits() throws Exception {
        CharacterDTO characterDTO = loadJson("exceededLimitsCharacterDTO.json", CharacterDTO.class);

        MvcResult result = mockMvc.perform(post("/api/stats/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(characterDTO)))
                .andExpect(status().isBadRequest())
                .andReturn();

        String responseJson = result.getResponse().getContentAsString();

        ErrorResponse actual = objectMapper.readValue(responseJson, ErrorResponse.class);

        Assertions.assertEquals(400, actual.getStatus());
        Assertions.assertEquals("/api/stats/calculate", actual.getPath());
        Assertions.assertEquals("Limit exceeded", actual.getError());
        Assertions.assertEquals("LIMIT_EXCEEDED", actual.getErrorCode());
        Assertions.assertEquals("Rune limit exceeded for VIGOR", actual.getMessage());
    }

    private <T> T loadJson(String path, Class<T> clazz) {
        try {
            String json = new String(
                    new ClassPathResource(path).getInputStream().readAllBytes(),
                    StandardCharsets.UTF_8
            );

            return objectMapper.readValue(json, clazz);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load JSON: " + path, e);
        }
    }
}
