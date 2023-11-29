package com.holub.application.service;

import com.holub.application.repository.MenuRepository;
import com.holub.application.setting.SetUp;

import java.util.HashMap;
import java.util.Map;

public class PriceManager {
    private static PriceManager instance;
    private final Map<String, Double> priceMap;
    private final MenuRepository menuRepository = MenuRepository.getInstance();

    private PriceManager() {
        priceMap = new HashMap<>();
        loadPrices();
    }

    public static synchronized PriceManager getInstance() {
        if (instance == null) {
            // TODO DB Select 넣고 개선 필요
            instance = new PriceManager();
        }
        return instance;
    }

    private void loadPrices() {

        String s = menuRepository.selectMenuAll();

        String[] lines = s.split("\n");

        for (String line : lines) {
            String[] parts = line.split("\t");
            if (parts.length >= 2) {
                String key = parts[0];
                Double value = Double.parseDouble(parts[1]);
                priceMap.put(key, value);
            }
        }
    }

    public double getPrice(String itemName) {
        return priceMap.getOrDefault(itemName, 0.0);
    }
}
