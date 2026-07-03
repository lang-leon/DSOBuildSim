package com.langleon.dsobuildsim.controller;

import com.langleon.dsobuildsim.character.dto.CharacterDTO;
import com.langleon.dsobuildsim.character.dto.CharacterStatsDTO;
import com.langleon.dsobuildsim.service.StatsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stats")
public class StatsController {

    private final StatsService service;

    public StatsController(StatsService service) {
        this.service = service;
    }

    @PostMapping("/calculate")
    public CharacterStatsDTO calculate(@RequestBody CharacterDTO dto)
    {
        return service.calculate(dto);
    }
}
