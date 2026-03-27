package com.langleon.dsobuildsim.service;

import com.langleon.dsobuildsim.gamedata.dto.GameDataDTO;
import com.langleon.dsobuildsim.gamedata.GameDataConfig;
import com.langleon.dsobuildsim.gamedata.GameDataMapper;
import org.springframework.stereotype.Service;

@Service
public class GameDataService {

    private final GameDataDTO gameDataDTO;

    public GameDataService(GameDataConfig config) {
        this.gameDataDTO = GameDataMapper.toDTO(config);
    }

    public GameDataDTO getGameData() {
        return gameDataDTO;
    }
}
