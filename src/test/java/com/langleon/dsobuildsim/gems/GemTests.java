package com.langleon.dsobuildsim.gems;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.langleon.dsobuildsim.enums.GemType;

import java.io.*;

public class GemTests {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream is = GemTests.class.getClassLoader().getResourceAsStream("data/gems.json");
        Reader reader = new InputStreamReader(is);
        GemData gemData = objectMapper.readValue(reader, GemData.class);
        System.out.println(gemData.getGems().keySet());
        Gem gem = gemData.createGem(GemType.RUBY, 10);
        System.out.println(gem);
        System.out.println(gemData.getUpgradeCost(gem)+" Dust");
    }
}
