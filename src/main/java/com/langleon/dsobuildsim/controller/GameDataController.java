package com.langleon.dsobuildsim.controller;

import com.langleon.dsobuildsim.dto.GameDataDTO;
import com.langleon.dsobuildsim.service.GameDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GameDataController {

    private final GameDataService service;

    public GameDataController(GameDataService service) {
        this.service = service;
    }

    @GetMapping("/game-data")
    public GameDataDTO getGameData() {
        return service.getGameData();
    }
}