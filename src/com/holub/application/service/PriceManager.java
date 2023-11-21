package com.holub.application.service;

import java.util.HashMap;
import java.util.Map;

public class PriceManager {
    private static PriceManager instance;
    private final Map<String, Double> priceMap;

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
        priceMap.put("wheat", 5.50);
        priceMap.put("white", 5.00);
        priceMap.put("honey_oat", 6.00);
        priceMap.put("oat", 5.75);
        priceMap.put("flatbread", 6.50);
        priceMap.put("mustard", 0.30);
        priceMap.put("chili", 0.45);
        priceMap.put("ranch", 0.50);
        priceMap.put("tomato", 0.25);
        priceMap.put("cheese", 0.75);
        priceMap.put("ham", 1.00);
        priceMap.put("coffee", 1.5);
        priceMap.put("tea", 1.0);
        priceMap.put("coke", 1.25);

    }

    public double getPrice(String itemName) {
        return priceMap.getOrDefault(itemName, 0.0);
    }
}
