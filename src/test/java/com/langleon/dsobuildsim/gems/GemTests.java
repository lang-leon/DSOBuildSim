package com.langleon.dsobuildsim.gems;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.langleon.dsobuildsim.enums.GemType;

import java.io.*;

public class GemTests {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream is = GemTests.class.getClassLoader().getResourceAsStream("data/gems.json");
        Reader reader = new InputStreamReader(is);
        GemConfig gemConfig = objectMapper.readValue(reader, GemConfig.class);
        GemFactory gemFactory = new GemFactory(gemConfig);
        Gem gem = gemFactory.createGem(GemType.RUBY, 10);
        System.out.println(gem);
        System.out.println(gemFactory.getUpgradeCost(gem)+" Dust");
    }


}
